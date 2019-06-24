import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class B_TreeTest {

    @Test
    public void testInsert() {
        B_Tree tree = new B_Tree(5);
        Assert.assertEquals(tree.root, null);
        tree.insert("a");
        Assert.assertEquals(tree.root.keys[0], "a");
    }

    @Test
    public void testSplitNode() {
        Node child1 = new Node(6);
        Node child2 = new Node(7);
        Node child3 = new Node(6);
        Node child4 = new Node(7);
        Node[] children1 = {child1, child2};
        Node[] children2 = {child3, child4};

        B_Tree tree = new B_Tree(4);
        Node node = new Node(4);
        node.addChildren(children1, 0);
        node.addChildren(children2, 2);
        node.addKey("a", 0);
        node.addKey("b", 1);
        node.addKey("c", 2);
        node.addKey("d", 3);

        Node right = new Node(4);
        right.addKey("a",0);
        right.addChildren(children1,0);

        Node left = new Node(4);
        left.addKey("c",0);
        left.addKey("d",1);
        left.addChildren(children2,0);

        Node[] expected = {right, left};

        Assert.assertEquals(tree.splitNode(node)[0].keys[0], expected[0].keys[0]);
        Assert.assertEquals(tree.splitNode(node)[1].keys[0], expected[1].keys[0]);
        Assert.assertEquals(tree.splitNode(node)[0].children[0], expected[0].children[0]);
        Assert.assertEquals(tree.splitNode(node)[1].children[0], expected[1].children[0]);
    }

    @Test
    public void testUpdateParentInChildren() {
        Node node = new Node(5);
        Node child = new Node(5);
        node.children[0] = child;
        Assert.assertEquals(node.children[0].parent, null);
        B_Tree.updateParentInChildren(node);
        Assert.assertEquals(node.children[0].parent, node);
    }

}
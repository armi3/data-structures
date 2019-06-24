import org.testng.Assert;
import org.testng.annotations.*;

public class NodeTest {

    @Test(groups = {"dev"}, description = "composite insertion")
    public void testAddKey() {
        Node node = new Node(5);
        Assert.assertEquals(node.keys[3], null);
        node.addKey("key", 3);
        Assert.assertEquals(node.keys[3], "key");
    }

    @Test(groups = {"dev"}, description = "composite insertion")
    public void testAddChildren() {
        Node node = new Node(5);
        Assert.assertEquals(node.children[3], null);
        Node child1 = new Node(6);
        Node child2 = new Node(7);
        Node[] children = {child1, child2};
        node.addChildren(children, 3);
        Assert.assertEquals(node.children[2], null);
        Assert.assertEquals(node.children[3], child1);
        Assert.assertEquals(node.children[4], child2);
        Assert.assertEquals(node.children[5], null);
    }
}
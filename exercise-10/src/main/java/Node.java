
public class Node {

    private Subnode[] children;
    private boolean isLeaf;

    public Node(Subnode[] children, boolean isLeaf) {
        this.children = children;
        this.isLeaf = isLeaf;
    }

    public Subnode[] getChildren() {
        return children;
    }

    public void setChildren(Subnode[] children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
}

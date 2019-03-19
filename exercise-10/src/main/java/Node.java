
public class Node {

    private Node parent;
    private Subnode[] children;
    private boolean isLeaf;

    public Node(Node parent, Subnode[] children, boolean isLeaf) {
        this.parent = parent;
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

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void addSubnode(Subnode subnode, int indexToPlace){

    }

    public String popSubnode(int indexToPop){

    }

}

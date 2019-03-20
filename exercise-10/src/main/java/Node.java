
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
        Subnode[] childrenUpdated = new Subnode[children.length+1];

        if (indexToPlace==0){
            System.arraycopy(getChildren(), 0, childrenUpdated, 1, getChildren().length-1);
            childrenUpdated[0]=subnode;
            setChildren(childrenUpdated);
            if(!isLeaf()){
                getChildren()[1].setLeft(subnode.getRight());
            }
        }
        else if(indexToPlace==getChildren().length) {
            System.arraycopy(getChildren(), 0, childrenUpdated, 0, getChildren().length-1);
            childrenUpdated[indexToPlace]=subnode;
            setChildren(childrenUpdated);
            if(!isLeaf()){

            }
        } else {
            System.arraycopy(getChildren(), 0, childrenUpdated, 0, indexToPlace+1);
            childrenUpdated[indexToPlace]=subnode;
            System.arraycopy(getChildren(), indexToPlace, childrenUpdated, indexToPlace+1, childrenUpdated.length-(indexToPlace+1));
            setChildren(childrenUpdated);
            if(!isLeaf()){
                getChildren()[getChildren().length-2].setRight(subnode.getLeft());
            }
        }
    }


    // won't reduce children array size
    public String popSubnodeKey(int indexToPop){
        return children[indexToPop].getKey();
    }

}

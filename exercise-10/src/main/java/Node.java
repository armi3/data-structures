
public class Node {

    private Node parent;
    private Subnode[] subnodes;
    private boolean isLeaf;

    public Node(Node parent, Subnode[] subnodes, boolean isLeaf) {
        this.parent = parent;
        this.subnodes = subnodes;
        this.isLeaf = isLeaf;
    }

    public Subnode[] getSubnodes() {
        return subnodes;
    }

    public void setSubnodes(Subnode[] subnodes) {
        this.subnodes = subnodes;
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
        Subnode[] childrenUpdated = new Subnode[getSubnodes().length+1];

        if (indexToPlace==0){ // leftmost subnode
            System.arraycopy(getSubnodes(), 0, childrenUpdated, 1, getSubnodes().length);
            childrenUpdated[0]=subnode;
            setSubnodes(childrenUpdated);
            if(!isLeaf()&&(getSubnodes().length>1)){
                getSubnodes()[1].setLeftChild(subnode.getRightChild());
            }
        }
        else if(indexToPlace== getSubnodes().length) { // rightmost subnode
            System.arraycopy(getSubnodes(), 0, childrenUpdated, 0, getSubnodes().length);
            childrenUpdated[indexToPlace]=subnode;
            setSubnodes(childrenUpdated);
            if(!isLeaf()){
                getSubnodes()[indexToPlace-1].setRightChild(getSubnodes()[indexToPlace].getLeftChild());
            }
        } else { // in between subnode
            System.arraycopy(getSubnodes(), 0, childrenUpdated, 0, indexToPlace);
            childrenUpdated[indexToPlace]=subnode;
            System.arraycopy(getSubnodes(), indexToPlace, childrenUpdated, indexToPlace+1, childrenUpdated.length-(indexToPlace+1));
            setSubnodes(childrenUpdated);
            if(!isLeaf()){
                getSubnodes()[indexToPlace-1].setRightChild(subnode.getLeftChild());
                getSubnodes()[indexToPlace+1].setLeftChild(subnode.getRightChild());

            }
        }
    }


    // won't reduce subnodes array size
    public String popSubnodeKey(int indexToPop){
        return subnodes[indexToPop].getKey();
    }

}

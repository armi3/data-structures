public class B_Tree {

    private Node root;
    private int degree;

    public B_Tree(int degree) {
        this.root = null;
        this.degree = degree;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void insert(String key){
        Subnode subnode = new Subnode(key);
        if (getRoot()==null){
            Subnode[] subnodes = new Subnode[1];
            subnodes[0] = subnode;
            Node newRoot = new Node(null, subnodes, true);
            setRoot(newRoot);

        }
        else {
            Node nodeToPlace = searchNodeToPlace(key, getRoot());
            int indexToPlace = searchIndexToPlace(key, nodeToPlace);
            nodeToPlace.addSubnode(subnode, indexToPlace);

            if(!(nodeToPlace.getSubnodes().length < degree)){
                // find median
                int medianIndex;
                if((getDegree()&1)==0){ // even degree
                    medianIndex = (getDegree()/2)-1;
                } else{ // odd degree
                    medianIndex = (getDegree()/2);
                }
                // push median to parent
                String poppedKey = nodeToPlace.popSubnodeKey(medianIndex);
                Node[] brokenNodes = breakNode(nodeToPlace, medianIndex); // left, right
                Subnode subnodeToPush = new Subnode(brokenNodes[0], poppedKey, brokenNodes[1]);
                // assing parent somewhere in here ?
                pushToParent(subnodeToPush, nodeToPlace);
            }
        }
    }

    public Node[] breakNode(Node nodeToBreak, int medianIndex){
        Subnode[] childrenLeft = new Subnode[medianIndex];
        Subnode[] childrenRight = new Subnode[nodeToBreak.getSubnodes().length-medianIndex-1];
        System.arraycopy(nodeToBreak.getSubnodes(), 0, childrenLeft, 0, medianIndex);
        System.arraycopy(nodeToBreak.getSubnodes(), medianIndex+1, childrenRight, 0, nodeToBreak.getSubnodes().length-medianIndex-1);

        Node left = new Node(nodeToBreak.getParent(), childrenLeft, nodeToBreak.isLeaf());
        Node right = new Node(nodeToBreak.getParent(), childrenRight, nodeToBreak.isLeaf());

        Node[] brokenNodes = {left, right};
        return brokenNodes;
    }

    // receives subnode already with children (broken nodes)
    public void pushToParent(Subnode subnode, Node nodeOverflowed){
        if(nodeOverflowed.getParent()==null){
            Subnode[] onlySubnode = new Subnode[1];
            onlySubnode[0] = subnode;
            Node newRoot = new Node(null, onlySubnode, false);

            onlySubnode[0].getRightChild().setParent(newRoot);
            onlySubnode[0].getLeftChild().setParent(newRoot);

            setRoot(newRoot);
            nodeOverflowed.setParent(getRoot());
        }
        else {
            int indexToPlace = searchIndexToPlace(subnode.getKey(), nodeOverflowed.getParent());
            nodeOverflowed.getParent().addSubnode(subnode, indexToPlace);

            if(!(nodeOverflowed.getSubnodes().length < degree)){
                // find median
                int medianIndex;
                if((getDegree()&1)==0){ // even degree
                    medianIndex = (getDegree()/2)-1;
                } else{ // odd degree
                    medianIndex = (getDegree()/2);
                }
                // push median to parent
                String poppedKey = nodeOverflowed.popSubnodeKey(medianIndex);
                Node[] brokenNodes = breakNode(nodeOverflowed, medianIndex);
                Subnode subnodeToPush = new Subnode(brokenNodes[0], poppedKey, brokenNodes[1]);
                pushToParent(subnodeToPush, nodeOverflowed.getParent());
            }


        }

    }

    // returns node where key goes
    public Node searchNodeToPlace(String key, Node node){
        int i = 0;
        while(i < node.getSubnodes().length-1){
            if(Interpreter.isGreater(key, node.getSubnodes()[i].getKey())){
                i++;
            } else{
                if(!node.isLeaf()){
                    return searchNodeToPlace(key, node.getSubnodes()[i].getLeftChild());
                }
                else{
                    return node;
                }
            }
        }
        if((!node.isLeaf())&&i==0){
            if(Interpreter.isGreater(key, node.getSubnodes()[0].getKey())){
                return searchNodeToPlace(key, node.getSubnodes()[i].getRightChild());

            }
            else{
                return searchNodeToPlace(key, node.getSubnodes()[i].getLeftChild());

            }

        }
        else if(!node.isLeaf()){
            return searchNodeToPlace(key, node.getSubnodes()[i].getRightChild());
        }
        return node;
    }

    public int searchIndexToPlace(String key, Node node){
        int i = 0;
        while(i < node.getSubnodes().length){
            if(Interpreter.isGreater(key, node.getSubnodes()[i].getKey())){
                i++;
            } else{
                return i;
            }
        }
        return i;
    }

}

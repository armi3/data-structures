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
        if (root==null){
            Subnode[] subnodes = new Subnode[1];
            subnodes[0] = subnode;
            this.root = new Node(null, subnodes, true);

        }
        else {
            Node nodeToPlace = searchNodeToPlace(key, root);
            int indexToPlace = searchIndexToPlace(key, nodeToPlace);
            nodeToPlace.addSubnode(subnode, indexToPlace);

            if(!(nodeToPlace.getChildren().length < degree)){
                // find median
                int medianIndex;
                if((this.degree&1)==0){ // even degree
                    medianIndex = (this.degree/2)-1;
                } else{ // odd degree
                    medianIndex = (this.degree/2);
                }
                // push median to parent
                String poppedKey = nodeToPlace.popSubnodeKey(medianIndex);
                Node[] brokenNodes = breakNode(nodeToPlace, medianIndex);
                Subnode subnodeToPush = new Subnode(brokenNodes[0], poppedKey, brokenNodes[1]);
                pushToParent(subnodeToPush, nodeToPlace);
            }
        }
    }

    public Node[] breakNode(Node nodeToBreak, int medianIndex){
        Subnode[] childrenLeft = new Subnode[medianIndex];
        Subnode[] childrenRight = new Subnode[nodeToBreak.getChildren().length-medianIndex-1];
        System.arraycopy(nodeToBreak.getChildren(), 0, childrenLeft, 0, medianIndex);
        System.arraycopy(nodeToBreak.getChildren(), medianIndex+1, childrenRight, 0, nodeToBreak.getChildren().length-medianIndex-1);

        Node left = new Node(nodeToBreak.getParent(), childrenLeft, nodeToBreak.isLeaf());
        Node right = new Node(nodeToBreak.getParent(), childrenRight, nodeToBreak.isLeaf());

        Node[] brokenNodes = {left, right};
        return brokenNodes;
    }

    // receives subnode already with children
    public void pushToParent(Subnode subnode, Node node){
        if(node.getParent()==null){
            Subnode[] subnodes = new Subnode[1];
            subnodes[0] = subnode;
            Node newRoot = new Node(null, subnodes, false);
            this.root = newRoot;
            node.setParent(this.root);
        }
        else {
            int indexToPlace = searchIndexToPlace(subnode.getKey(), node.getParent());
            node.getParent().addSubnode(subnode, indexToPlace);

            if(!(node.getChildren().length < degree)){
                // find median
                int medianIndex;
                if((this.degree&1)==0){ // even degree
                    medianIndex = (this.degree/2)-1;
                } else{ // odd degree
                    medianIndex = (this.degree/2);
                }
                // push median to parent
                String poppedKey = node.popSubnodeKey(medianIndex);
                Node[] brokenNodes = breakNode(node, medianIndex);
                Subnode subnodeToPush = new Subnode(brokenNodes[0], poppedKey, brokenNodes[1]);
                pushToParent(subnodeToPush, node);
            }


        }

    }

    // returns node where key goes
    public Node searchNodeToPlace(String key, Node node){
        int i = 0;
        while(i < node.getChildren().length){
            if(Interpreter.isGreater(key, node.getChildren()[i].getKey())){
                i++;
            } else{
                if(!node.isLeaf()){
                    searchNodeToPlace(key, node.getChildren()[i].getLeft());
                }
                else{
                    return node;
                }
            }
        }
        if(!node.isLeaf()){
            searchNodeToPlace(key, node.getChildren()[i-1].getRight());
        }
        return node;
    }

    public int searchIndexToPlace(String key, Node node){
        int i = 0;
        while(i < node.getChildren().length){
            if(Interpreter.isGreater(key, node.getChildren()[i].getKey())){
                i++;
            } else{
                return i;
            }
        }
        return i;
    }

}

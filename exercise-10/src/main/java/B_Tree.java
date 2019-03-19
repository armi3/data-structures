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
                String poppedKey = nodeToPlace.popSubnode(medianIndex);
                pushToParent(poppedKey, nodeToPlace.getParent());
            }
        }
    }

    public void pushToParent(String key, Node node){
        Subnode subnode = new Subnode(key);
        if(node==null){
            Subnode[] subnodes = new Subnode[1];
            subnodes[0] = subnode;
            Node newRoot = new Node(null, subnodes, false);
            this.root = newRoot;
        }
        else {
            int indexToPlace = searchIndexToPlace(key, node);
            node.addSubnode(subnode, indexToPlace);

            if(!(node.getChildren().length < degree)){
                // find median
                int medianIndex;
                if((this.degree&1)==0){ // even degree
                    medianIndex = (this.degree/2)-1;
                } else{ // odd degree
                    medianIndex = (this.degree/2);
                }
                // push median to parent
                String poppedKey = node.popSubnode(medianIndex);
                pushToParent(poppedKey, node.getParent());
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
        return 0;
    }

}

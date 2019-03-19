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
        Node nodeToPlace = searchNodeToPlace(key, root);
        if (){

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

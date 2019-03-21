public class Subnode {
    private Node leftChild;
    private String key;
    private Node rightChild;



    public Subnode(Node leftChild, String key, Node rightChild) {
        this.rightChild = rightChild;
        this.key = key;
        this.leftChild = leftChild;
    }

    public Subnode(String key) {
        this.rightChild = null;
        this.key = key;
        this.leftChild = null;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }
}

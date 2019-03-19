public class Subnode {
    private Node right;
    private String key;
    private Node left;

    public Subnode(Node right, String key, Node left) {
        this.right = right;
        this.key = key;
        this.left = left;
    }

    public Subnode(String key) {
        this.right = null;
        this.key = key;
        this.left = null;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}

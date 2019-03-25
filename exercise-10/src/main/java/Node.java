import java.util.Arrays;

public class Node {

    public boolean isLeaf;
    public Node parent;
    public String[] keys; // n = m-1
    public Node[] children; // m



    public Node(int m) {
        this.parent = null;
        this.children = new Node[m+2]; // let it overflow once
        this.keys = new String[m+1]; // let it overflow once
        this.isLeaf = true;
    }

    @Override
    public String toString() {
        int i=0;
        while(keys[i]!=null && i<keys.length-2){
            i++;
        }
        String[] keysToString = new String[i+1];
        System.arraycopy(keys, 0, keysToString, 0, i+1);

        return "Node{" +
                "isLeaf=" + isLeaf +
                ", keys=" + Arrays.toString(keysToString) +
                '}';
    }

    public void addKey(String key, int index){
        String[] updatedKeys = new String[keys.length];
        System.arraycopy(keys, 0, updatedKeys, 0, index);
        updatedKeys[index] = key;
        System.arraycopy(keys, index+1, updatedKeys, index+1, keys.length-index-1);
        keys = updatedKeys;
    }

    public void addChildren(Node[] newChildren, int index){
        Node[] updatedChildren = new Node[children.length];
        System.arraycopy(children, 0, updatedChildren, 0, index);
        updatedChildren[index] = newChildren[0];
        updatedChildren[index+1] = newChildren[1];
        System.arraycopy(children, index+1, updatedChildren, index+2, children.length-index-2);
        children = updatedChildren;

    }


}

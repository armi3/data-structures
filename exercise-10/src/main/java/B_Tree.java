public class B_Tree {

    public Node root;
    public int degree;
    public int median;

    public B_Tree(int m) {
        this.root = null;
        this.degree = m;
        if((degree&1)==0){ // even degree
            this.median = (degree/2)-1;
        } else{ // odd degree
            this.median = (degree/2);
        }
    }

    public void insert(String key){
        if (root==null){ // first insert case
            root = new Node(degree);
            root.keys[0] = key;
        }
        else {
            Node leafToPlaceKey = getLeafToPlaceKey(key, root);


            int indexToPlaceKey = getIndexToPlaceKey(key, leafToPlaceKey);
            leafToPlaceKey.addKey(key, indexToPlaceKey);

            overflowFixer(leafToPlaceKey);
        }
    }

    public void overflowFixer(Node node){
        if(node.keys[degree-1]!=null){ // check if node overflowed
            // split node
            Node[] splitNodes = splitNode(node);
            // make split nodes parent to their children (if node isn't leaf)
            if(!node.isLeaf){
                updateParentInChildren(splitNodes[0]);
                updateParentInChildren(splitNodes[1]);
            }
            // push median key to parent
                // node isn't root  ->  push to existing parent
            if(node.parent!=null){
                int indexToPlaceKey = getIndexToPlaceKey(node.keys[median], node.parent);
                node.parent.addKey(node.keys[median], indexToPlaceKey);
                // make split nodes children to node's parent
                node.parent.addChildren(splitNodes, indexToPlaceKey);
                overflowFixer(node.parent);
            }
                // node is root     ->  create parent, make new root
            else {
                root = new Node(degree);
                root.keys[0] = node.keys[median];
                // make split nodes children to node's parent
                splitNodes[0].parent = root;
                splitNodes[1].parent = root;
                root.isLeaf = false;
                root.addChildren(splitNodes, 0);
            }
            // check if parent overflowed (only if root)
            //overflowFixer(node.parent);
        }
    }

    public Node[] splitNode(Node node){
        Node left = new Node(degree);
        left.parent = node.parent;
        left.isLeaf = node.isLeaf;
        System.arraycopy(node.keys, 0, left.keys, 0, median);
        System.arraycopy(node.children, 0, left.children, 0, median+1);

        Node right = new Node(degree);
        right.parent = node.parent;
        right.isLeaf = node.isLeaf;
        System.arraycopy(node.keys, median+1, right.keys, 0, degree-median);
        System.arraycopy(node.children, median+1, right.children, 0, degree-median);

        Node[] splitNodes = {left, right};
        return splitNodes;
    }

    public void updateParentInChildren(Node node){
        for (Node i : node.children){
            if(i!=null){
                i.parent = node;
            }
        }
    }

    public Node getLeafToPlaceKey(String key, Node node){
        int i = 0;
        while(node.keys[i]!=null && i<(degree-1)){
            if(Interpreter.isGreater(key, node.keys[i])){
                i++;
            } else {
                if(!node.isLeaf && (i+1)<node.keys.length){
                    return getLeafToPlaceKey(key, node.children[i]);
                } else {
                    return node;
                }
            }
        }
        if(!node.isLeaf){
            return getLeafToPlaceKey(key, node.children[i]);
        }
        return node;
    }

    public int getIndexToPlaceKey(String key, Node node){
        int i = 0;
        while(node.keys[i]!=null && (i < degree)){
            if(Interpreter.isGreater(key, node.keys[i])){
                i++;
            } else{
                return i;
            }
        }
        return i;
    }


    public void printInorder(Node node){
        int i = 0;
        while(node.children[i]!=null && i<(degree-1)){
            if(!node.isLeaf){
                printInorder(node.children[i]);
                i++;
            } else {
                System.out.println(node.toString());
            }
        }
        System.out.println(node.toString());
    }
}

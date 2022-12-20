//Lowest Common ancestor

class Node {
    Node left;
    Node right;
    int data;
}

class BST {

    public Node findLCA(Node node,int n1,int n2){
        if(node==null){
            return null;
        }

        while(node!=null){
            if(node.data>n1 && node.data>n2){
                node=node.left;
            }else if(node.data<n1 && node.data<n2){
                node=node.right;
            }else{                      //The LCA is the node where one value is bigger than the node data and the other lower
                break;
            }
        }

        return node;
    }

    public Node insert(Node node, int val) {
        if(node == null) {
            return createNewNode(val);
        }

        if(val < node.data) {
            node.left = insert(node.left, val);
        } else if((val > node.data)) {
            node.right = insert(node.right, val);
        }

        return node;
    }

    public Node createNewNode(int k) {
        Node a = new Node();
        a.data = k;
        a.left = null;
        a.right = null;
        return a;
    }
}

public class BST16 {

    public static void main(String[] args) {
        BST a = new BST();
        Node root = null;

        root = a.insert(root, 8);
        root = a.insert(root, 3);
        root = a.insert(root, 6);
        root = a.insert(root, 10);
        root = a.insert(root, 4);
        root = a.insert(root, 7);
        root = a.insert(root, 1);
        root = a.insert(root, 14);
        root = a.insert(root, 13);

        Node lca=a.findLCA(root,2,6);

        if(lca!=null){
            System.out.println(lca.data);
        }

    }

}
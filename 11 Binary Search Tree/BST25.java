//Remove nodes outside given range
//Its effective to solve this in post order manner
class Node {
    Node left;
    Node right;
    int data;
}

class BST {

    public Node removeBSTKeysOutsideGivenRange(Node node,int min,int max){
        if(node==null){
            return null;
        }

        node.left=removeBSTKeysOutsideGivenRange(node.left,min,max);
        node.right=removeBSTKeysOutsideGivenRange(node.right,min,max);

        if(node.data<min){
            node=node.right;
        }else if(node.data>max){
            node=node.left;
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

public class BST25 {

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

        root = a.removeBSTKeysOutsideGivenRange(root, 4,10);

    }

}
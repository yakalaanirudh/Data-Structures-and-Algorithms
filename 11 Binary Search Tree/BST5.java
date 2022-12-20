//Here we print the elements of BST in Postorder
//We print a node only after all its children on both sides are printed
class Node {
    Node left;
    Node right;
    int data;
}

class BST {

    public void postorder(Node node) {
        if(node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+ " ");
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

public class BST5 {

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

        a.postorder(root);
    }

}

/*
BST is
                                    8
                            3                   10
                    1               6                   14
                                4       7           13

//The output is 1,4,7,6,3,13,14,10,8
 */
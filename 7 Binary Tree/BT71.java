//Check if given Binary Tree is BST

class Node {
    Node left;
    Node right;
    int data;
}

class BinaryTree {

    Node prev = null;

    public boolean isTreeBST(Node node) {
        if (node == null) {
            return true;
        }

        if (!isTreeBST(node.left)) {
            return false;
        }

        if (prev != null && node.data < prev.data) {
            return false;
        }

        prev = node;

        return isTreeBST(node.right);
    }

    public Node createNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
}

public class BT71 {

    public static void main(String[] args) {

        BinaryTree a = new BinaryTree();

        Node root = a.createNewNode(12);
        root.left = a.createNewNode(7);
        root.left.left = a.createNewNode(6);
        root.left.left.left = a.createNewNode(2);
        root.left.right = a.createNewNode(9);
        root.left.right.left = a.createNewNode(8);
        root.right = a.createNewNode(24);

        System.out.println(a.isTreeBST(root));

    }
}
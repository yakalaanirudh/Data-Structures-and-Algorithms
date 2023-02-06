//Get Minimum distance to Leaf from Root in Binary Tree

class Node {
    Node left;
    Node right;
    int data;
}

class BinaryTree {

    public int getMinDistanceToLeaf(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {
            return 0;
        }

        return 1 + Math.min(getMinDistanceToLeaf(node.left), getMinDistanceToLeaf(node.right));
    }

    public Node createNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
}

public class BT52 {

    public static void main(String[] args) {

        BinaryTree a = new BinaryTree();

        Node root = a.createNewNode(2);
        root.left = a.createNewNode(7);
        root.right = a.createNewNode(9);
        root.left.left = a.createNewNode(2);
        root.left.right = a.createNewNode(6);
        root.left.right.left = a.createNewNode(5);
        root.left.right.right = a.createNewNode(11);

        System.out.println(a.getMinDistanceToLeaf(root));
    }
}
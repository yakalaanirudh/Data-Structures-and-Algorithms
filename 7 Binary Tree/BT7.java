//Get Height of a Binary Tree/Node

class Node {
    Node left;
    Node right;
    int data;
}

class BinaryTree {
    /*
     * It'll return height of tree in Binary Tree
     */
    public int getHeightOfTree(Node node) {
        if (node == null) {
            return -1;
        }

        return Math.max(getHeightOfTree(node.left), getHeightOfTree(node.right)) + 1;
    }

    public Node createNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
}

public class BT7{
    public static void main(String[] args) {

        BinaryTree a = new BinaryTree();

        Node root = a.createNewNode(2);
        root.left = a.createNewNode(7);
        root.right = a.createNewNode(5);
        root.left.left = a.createNewNode(2);
        root.left.right = a.createNewNode(6);
        root.left.right.left = a.createNewNode(5);
        root.left.right.right = a.createNewNode(11);
        root.right.right = a.createNewNode(9);
        root.right.right.left = a.createNewNode(4);

        System.out.print("Total Leaf Nodes: " + a.getHeightOfTree(root));
    }

}
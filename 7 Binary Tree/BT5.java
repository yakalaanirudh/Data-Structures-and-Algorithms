//Get Number of Nodes in a Binary Tree

class Node {
    Node left;
    Node right;
    int data;
}

class BinaryTree {
    /*
     * It'll return total number of nodes in Binary Tree
     */
    public int getNumberOfNodes(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + getNumberOfNodes(node.left) + getNumberOfNodes(node.right);
    }

    public Node createNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
}

public class BT5 {

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

        System.out.print("Total Nodes: " + a.getNumberOfNodes(root));
    }

}
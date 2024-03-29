//Print elements at given level in Binary Tree


package binarytree;

class Node {
    Node left;
    Node right;
    int data;
}

class BinaryTree {
    /*
     * It'll print all values for a given level in Binary Tree
     */
    public void printAtGivenLevel(Node node, int level) {
        if (node == null) {
            return;
        }

        if(level == 1) {
            System.out.print(node.data + " ");
            return;
        }

        printAtGivenLevel(node.left, level - 1);
        printAtGivenLevel(node.right, level - 1);
    }

    public Node createNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
}

public class BT8 {

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

        a.printAtGivenLevel(root, 4);
    }

}
//Check if Two Trees are Mirror Structure to each other

class Node {
    Node left;
    Node right;
    int data;
}

class BinaryTree {

    public boolean ifMirrorStructureTree(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return ifMirrorStructureTree(node1.left, node2.right) && ifMirrorStructureTree(node1.right, node2.left);
    }

    public Node createNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
}

public class BT34 {

    public static void main(String[] args) {

        BinaryTree a = new BinaryTree();

        Node root1 = a.createNewNode(2);
        root1.left = a.createNewNode(7);
        root1.right = a.createNewNode(8);
        root1.left.left = a.createNewNode(5);

        Node root2 = a.createNewNode(3);
        root2.left = a.createNewNode(6);
        root2.right = a.createNewNode(7);
        root2.right.right = a.createNewNode(5);

        System.out.println(a.ifMirrorStructureTree(root1, root2));
    }

}

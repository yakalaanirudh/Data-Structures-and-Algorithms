//Print Right View of Binary Tree

class Node {
    Node left;
    Node right;
    int data;
}

class BinaryTree {
    int maxLevel;

    public void rightViewOfTree(Node node, int level) {
        if(node == null) {
            return;
        }

        if(level >= maxLevel) {
            System.out.print(node.data + " ");
            maxLevel++;
        }

        rightViewOfTree(node.right, level + 1);
        rightViewOfTree(node.left, level + 1);
    }

    public Node createNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
}

public class BT15 {

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

        a.rightViewOfTree(root, 0);
    }

}
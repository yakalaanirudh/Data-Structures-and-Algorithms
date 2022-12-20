//Check if a Binary Tree is a Binary Search Tree
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

        if (prev != null && node.data < prev.data) {        //Here we take left leaf node
            return false;
        }

        prev = node;            //Here we are assigning current node value to prev

        return isTreeBST(node.right);           //Going to right node
    }

    public Node createNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
}

public class BST20 {

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

/*
If we create a inorder array with BST it should be increasing

But creating inorder array and comparing two calues is space and time inefficient

So we sav ethe previous node value in a variable and compare it to current node value

If it is less(previous<current) then true else false


 */
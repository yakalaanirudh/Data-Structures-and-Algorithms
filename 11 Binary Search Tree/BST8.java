//To return a sibling element in BST
class Node {
    Node left;
    Node right;
    int data;
}

class BST {

    public Node getSiblingNode(Node node, int val) {
        if(node == null || node.data == val) {
            return null;
        }

        Node parentNode = null;

        while(node != null) {
            if(val < node.data) {
                parentNode = node;
                node = node.left;
            } else if(val > node.data) {
                parentNode = node;
                node = node.right;
            } else {
                break;
            }
        }

        if(parentNode.left != null && val == parentNode.left.data) {
            return parentNode.right;
        }

        if(parentNode.right != null && val == parentNode.right.data) {
            return parentNode.left;
        }

        return null;
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

public class BST8 {

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

        Node siblingNode = a.getSiblingNode(root, 3);
        if(siblingNode != null) {
            System.out.println("Sibling: " + siblingNode.data);
        } else {
            System.out.println("No Sibling");
        }
    }

}

/*

    public Node getSiblingNode(Node node, int val) {
        if(node == null || node.data == val) {
            return null;
        }

        We wrote
        || node.data == val
        because if we give root value it will give error as root doesnt have a sibling node
        this prevents it
        If nodes data (root node value) is value return null
 */


/*

        if(parentNode.left != null && val == parentNode.left.data) {
            return parentNode.right;
        }

        if(parentNode.right != null && val == parentNode.right.data) {
            return parentNode.left;
        }

        Lets say we find sibling node of 14

        It will store parent node as 10

        But we write

        if(parentNode.left != null) {
            return parentNode.right;
        }
        since 10s left node is null it will give null pointer exception so we to avoid it we write

        if(parentNode.left != null && val == parentNode.left.data) {
            return parentNode.right;
        }

 */

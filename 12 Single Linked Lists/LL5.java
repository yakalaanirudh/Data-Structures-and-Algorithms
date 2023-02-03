//Insert element at beginning/front

/*
 * Node class contains the LinkedList Node Structure. (int Data & a reference point)
 */
class Node {
    Node next;
    int data;
}

/*
 * Linked class contains the necessary functions to make the operations.
 */
class Linked {
    Node root;

    public Linked() {
        root = null;
    }

    /*
     * getNewNode() method to generate a new node
     */
    public Node getNewNode(int key) {
        Node a = new Node();
        a.next = null;
        a.data = key;
        return a;
    }

    /*
     * insertAtStart method is used to insert the element at the starting in
     * Linked List
     */
    public Node insertAtStart(Node node, int key) {
        if (node == null)
            return getNewNode(key);
        Node newNode = getNewNode(key);
        newNode.data = key;
        newNode.next = node;
        return newNode;
    }

    /*
     * insert method is used to insert the element in Linked List
     */
    public Node insert(Node node, int key) {
        if (node == null)
            return getNewNode(key);
        else
            node.next = insert(node.next, key);

        return node;
    }
}

/*
 * LinkedList class to initiate the operation.
 */
public class LL5 {

    public static void main(String[] args) {

        Node root = null;
        Linked a = new Linked();
        root = a.insert(root, 1);
        root = a.insert(root, 2);
        root = a.insert(root, 3);
        root = a.insert(root, 4);
        root = a.insertAtStart(root, 5);
    }
}
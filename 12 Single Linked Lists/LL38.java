//Delete the Linked List

class Node {
    Node next;
    int data;
}

class Linked {
    /*
     * It'll delete the linked list
     */
    public Node deleteList(Node node) {
        return null;
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
     * insert method is used to insert the element in Linked List
     */
    public Node insert(int key, Node node) {

        if (node == null)
            return getNewNode(key);
        else
            node.next = insert(key, node.next);

        return node;
    }

    /*
     * It'll print the complete linked list
     */
    public void printList(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        printList(node.next);
    }
}

public class LL38 {

    public static void main(String[] args) {

        Node head = null;
        Linked a = new Linked();

        head = a.insert(12, head);
        head = a.insert(99, head);
        head = a.insert(37, head);
        head = a.insert(37, head);
        head = a.insert(99, head);
        head = a.insert(12, head);

        a.printList(head);
        System.out.println();

        a.deleteList(head);
    }
}
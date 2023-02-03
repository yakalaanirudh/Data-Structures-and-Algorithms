//Delete last node of list

class Node {
    Node next;
    int data;
}

class Linked {

    /*
     * It'll delete last node of linked list
     */
    public Node delete(Node node) {
        if (node == null || node.next == null) {
            return null;
        }

        Node tmp = node;

        while(tmp.next.next != null) {
            tmp = tmp.next;
        }

        tmp.next = null;
        return node;
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

    public void printList(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        printList(node.next);
    }
}

public class LL8 {

    public static void main(String[] args) {

        Node root = null;
        Linked a = new Linked();

        root = a.insert(12, root);
        root = a.insert(99, root);
        root = a.insert(37, root);
        a.printList(root);
        System.out.println();

        root = a.delete(root);

        a.printList(root);

    }
}
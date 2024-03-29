//Get Kth Node from Linked List

class Node {
    Node next;
    int data;
}

class Linked {
    /*
     * Return kth node of linked list
     */
    public int returnKthNode(Node node, int k) {
        if(node == null) {
            System.out.println("Linked list is empty");
            return -1;
        }

        for(int i = 1; i < k; i++) {
            node = node.next;
            if(node == null) {
                System.out.println("k is greater than total node present in list");
                return -1;
            }
        }

        return node.data;
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

public class LL30 {

    public static void main(String[] args) {

        Node head = null;
        Linked a = new Linked();

        head = a.insert(12, head);
        head = a.insert(99, head);
        head = a.insert(12, head);
        head = a.insert(8, head);
        head = a.insert(8, head);

        a.printList(head);
        System.out.println();

        System.out.println("Kth Node: " + a.returnKthNode(head, 2));
    }
}
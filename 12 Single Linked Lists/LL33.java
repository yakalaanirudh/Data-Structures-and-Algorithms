//Detect & get Length of loop in linked list

class Node {
    Node next;
    int data;
}

class Linked {
    /*
     * It'll return length of loop in linked list
     */
    public int lengthOfLoop(Node head) {
        if(head == null) {
            return -1;
        }

        Node slow, fast;
        slow = fast = head;
        int length = 0;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow.data == fast.data) {
                break;
            }
        }

        if(slow == fast) {
            while(slow.next != fast) {
                slow = slow.next;
                length++;
            }
            length++;
        }

        return length;
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

public class LL33 {

    public static void main(String[] args) {

        Node head = null;
        Linked a = new Linked();

        head = a.insert(12, head);
        head = a.insert(99, head);
        head = a.insert(37, head);
        head = a.insert(5, head);
        head = a.insert(25, head);

        head.next.next.next.next.next = head.next;

        System.out.println(a.lengthOfLoop(head));
    }
}
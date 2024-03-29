//Delete element at given position | Iterative Method


class Node {
    int data;
    Node next;
}

class LinkedList {

    private Node getNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.next =  null;

        return newNode;
    }

    public Node deleteElementAtPosition(Node node, int position) {
        if (position < 1) {
            System.out.println("Position can't be less than 1");
            return node;
        }

        if (node == null && position >= 1) {
            System.out.println("Position is greater than number of elements exists");
            return node;
        }

        if(position == 1) {
            return node.next;
        }

        Node firstNode = node;
        Node prev = null;

        while(node.next != null && position > 1) {
            prev = node;
            node = node.next;
            position--;
        }

        if(position != 1) {
            System.out.println("Position is greater than number of elements exists");
            return firstNode;
        }

        prev.next = node.next;

        return firstNode;
    }

    public Node insert(Node node, int val) {
        if(node == null) {
            return getNewNode(val);
        }

        Node firstNode = node;

        while(node.next != null) {
            node = node.next;
        }

        node.next = getNewNode(val);
        return firstNode;
    }

    public void printList(Node node) {
        if(node == null) {
            return;
        }

        while(node != null) {
            System.out.print(node.data + " ");

            node = node.next;
        }
    }
}


public class LL11 {

    public static void main(String[] args) {

        LinkedList obj = new LinkedList();
        Node head = null;

        head = obj.insert(head, 12);
        head = obj.insert(head, 7);
        head = obj.insert(head, 8);
        head = obj.insert(head, 10);
        head = obj.insert(head, 5);

        obj.printList(head);
        System.out.println();

        head = obj.deleteElementAtPosition(head, 3);

        obj.printList(head);
        System.out.println();

    }
}
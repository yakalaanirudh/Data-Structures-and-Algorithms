//Add 1 to a number represented as linked list

class Node {
    Node next;
    int data;
}

class Linked {

    public int addOneToList(Node node){

        if(node==null){
            return 1;
        }

        int res=node.data+addOneToList(node.next);

        node.data=res%10;
        return res/10;
        
    }

    public Node addOne(Node node){

        int c=addOneToList(node);

        if(c==1){
            Node head=this.createNewNode(1);
            head.next=node;
            return head;
        }
        
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

public class LL55 {
    public static void main(String[] args) {
        Node head = null;
        Linked a = new Linked();

        head = a.insert(2, head);
        head = a.insert(1, head);
        head = a.insert(0, head);
        head = a.insert(1, head);
        head = a.insert(2, head);
        head = a.insert(1, head);

        head = a.addOne(head);

        a.printList(head);
    }
}
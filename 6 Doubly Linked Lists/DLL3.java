//Here we insert node at any given position
class Node{
    int data;
    Node next;
    Node previous;
}

class DoublyLinkedList{
    public Node getNewNode(int i){
        Node a=new Node();
        a.data=i;
        a.next=null;
        a.previous=null;

        return a;
    }

    public Node insert(int i,Node node){
        if(node==null){                 //In the argument we pass head node
            return getNewNode(i);       //So if head node is null create new
        }else {

            Node head = node;                 //save current function argument node(head) in a temp variable head

            while (node.next != null) {         //Iterate till the next node of head linked list is null
                node = node.next;             //save next node in node which is reassigned
            }

            Node a = getNewNode(i);           //Create new node
            a.previous = node;                //Linking the node to head
            node.next = a;

            return head;
        }
    }


    public Node insertAtGivenPosition(Node head,int data,int position){
        if (head == null) {
            if(position==1){
                return getNewNode(data);    //If head is null and insert at first position create new node and return it
            }else{
                return null;                //If head is null and insert not at first position return null
            }
        }

        if(position==1){
            Node t=getNewNode(data);    //Create new node
            head.previous=t;            //Link it
            t.next=head;

            return t;
        }else {

            Node node = head;                 //Save current dll in a temp variable node

            while (node != null && position > 2) {
                node = node.next;             //Iterate to next node till position>2 and next node whicj becomes current is not null
                position--;
            }

            //If next node which becomes current is null    it means we are inserting beyond end of DLL
            if (node == null) {
                System.out.println("Position is not valid");
                return head;
            }else {

                Node t = getNewNode(data);        //create new node
                t.next = node.next;               //new node next is current node next
                t.previous = node;                //new node previous is current node
                if (node.next != null) {            //If current node next not null
                    node.next.previous = t;       //current node next previous is new node
                } else {
                    node.next = t;                //current node next is new node
                }
                return head;
            }
        }
    }
}


public class DLL3{
    public static void main(String[] args){
        DoublyLinkedList a=new DoublyLinkedList();
        Node head=null;

        head=a.insert(12,head);
        head=a.insert(99,head);
        head=a.insert(37,head);
        head=a.insert(5,head);
        head=a.insert(25,head);

        head=a.insertAtGivenPosition(head,29,1);

    }
}
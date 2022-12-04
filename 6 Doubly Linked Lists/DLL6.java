//Here we delete a node(by position) from a doubly Linked list
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
        }

        Node head=node;                 //save current function argument node(head) in a temp variable head

        while(node.next!=null){         //Iterate till the next node of head linked list is null
            node=node.next;             //save next node in node which is reassigned
        }

        Node a=getNewNode(i);           //Create new node
        a.previous=node;                //Linking the node to head
        node.next=a;

        return head;
    }

    public Node DeleteNodeAtGivenPosition(Node head,int position){
        if(head==null){
            return head;                    //If head is null return null
        }

        if(position==1){
            if(head.next!=null){
                head.next.previous=null;    //If 2nd node not null set 2nd node previous to null
            }else{
                return head.next;           //return 2nd node
            }
        }

        Node node=head;                     //Save head in a temp variable node

        while(node!=null&&position>1){
            node=node.next;                 //Iterate to next node
            position--;
        }

        if(node==null){
            System.out.println("Element not present");
            return head;
        }
        //The pointer will stop at the node position to be deleted let that node be current node cr
        if(node.next!=null){
            node.next.previous=node.previous;   //set CRs next previous to CRs previous
        }else{
            node.previous.next=node.next;       //Set to null
        }
        return head;
    }
}

public class DLL6{
    public static void main(String[] args){
        DoublyLinkedList a=new DoublyLinkedList();
        Node head=null;

        head=a.insert(12,head);
        head=a.insert(99,head);
        head=a.insert(37,head);
        head=a.insert(5,head);
        head=a.insert(25,head);

        head=a.DeleteNodeAtGivenPosition(head,1);

    }
}
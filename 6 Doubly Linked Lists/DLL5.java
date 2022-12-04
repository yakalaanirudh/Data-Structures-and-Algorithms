//Here we delete a node(by value) from a doubly Linked list
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

    public Node DeleteFirstNode(Node head){
        if(head==null){
            return null;        //If head null return null
        }
        if(head.next!=null){
            head.next.previous=null;    //Set 2nd node prev to null
        }

        return head.next;               //return 2nd node

    }

    public Node DeleteNode(Node head,int data){
        if(head==null){
            return head;            //If head is null return null
        }

        if(head.data==data){        //If data in head node
            if(head.next!=null){
                head.next.previous=null;        //Set 2nd node previous to null
            }
            return head.next;                   //return 2nd node
        }

        Node node=head;                 //Save DLL in a temp variable

        while(node!=null){
            if(node.data==data){        //If data in current node matches break
                break;
            }else {
                node = node.next;       //If data in current node doesnt match shift to next node
            }
        }

        if(node==null){
            System.out.println("Element doest exist");
            return head;
        }
        //current node is where data is present
        if(node.next!=null){
            node.next.previous=node.previous;   //Set the current nodes next previous to current nodes previous
        }else {
            node.previous.next = node.next;     //The element deleted is last so set the 2nd last next to null
        }
        return head;
    }
}

public class DLL5{
    public static void main(String[] args){
        DoublyLinkedList a=new DoublyLinkedList();
        Node head=null;

        head=a.insert(12,head);
        head=a.insert(99,head);
        head=a.insert(37,head);
        head=a.insert(5,head);
        head=a.insert(25,head);

        head=a.DeleteNode(head,25);

    }
}
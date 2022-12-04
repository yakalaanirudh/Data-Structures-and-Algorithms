//Here we print all nodes of doubly linked list
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

    public void printList(Node node){
        if(node==null){
            return;
        }

        while(node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
    }
}

public class DLL8{
    public static void main(String[] args){
        DoublyLinkedList a=new DoublyLinkedList();
        Node head=null;

        head=a.insert(12,head);
        head=a.insert(99,head);
        head=a.insert(37,head);
        head=a.insert(5,head);
        head=a.insert(25,head);

        a.printList(head);
    }
}
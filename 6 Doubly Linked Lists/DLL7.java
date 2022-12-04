//We calculate the size of list
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

    public int getSizeOfList(Node node){
        if(node==null){
            return 0;
        }

        int count=0;

        while(node!=null){
            count++;
            node=node.next;
        }

        return count;
    }
}

public class DLL7{
    public static void main(String[] args){
        DoublyLinkedList a=new DoublyLinkedList();
        Node head=null;

        head=a.insert(12,head);
        head=a.insert(99,head);
        head=a.insert(37,head);
        head=a.insert(5,head);
        head=a.insert(25,head);

        System.out.println("Size: "+a.getSizeOfList(head));

    }

}
//Here we rotate a doubly Linked list(counter clock wise) by n positions
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

    public Node rotateList(Node head,int k){
        if(head==null || head.next==null){
            return head;                //If head is null or no 2nd node return node
        }

        Node node=head;                 //Save head in a temporary variable node

        k=k%getSizeOfList(head);        //get remainder
        if(k==0){
            return head;
        }else{
            while(node!=null &k>1){     //The pointer will stop at 1 the current nodes next is new head
                node=node.next;
                k--;
            }

            Node newHead=node.next;     //Setting newhead
            newHead.previous=null;      //newhead previous=null
            node.next=null;             //current node next=null


            Node temp=newHead;          //Save newHead in a temp variable
            while(temp.next!=null){
                temp=temp.next;
            }

            temp.next=head;             //when temp.next becomes null set temp.next to head
            head.previous=temp;         //when temp.next becomes null set head.previous to temp

            return newHead;
        }
    }
}

public class DLL9{
    public static void main(String[] args){
        DoublyLinkedList a=new DoublyLinkedList();
        Node head=null;

        head=a.insert(12,head);
        head=a.insert(99,head);
        head=a.insert(37,head);
        head=a.insert(5,head);
        head=a.insert(25,head);

        head=a.rotateList(head,7);
    }
}
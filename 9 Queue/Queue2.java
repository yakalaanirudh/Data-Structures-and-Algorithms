//Implementing Queue using LinkedList
class Node{
    int data;
    Node next;
}

class QueueLinked{
    Node first;
    Node last;
    int size;

    public Node getNewNode(int val){
        Node a=new Node();
        a.data=val;
        a.next=null;
        return a;
    }

    //Complexity O(1)
    public void insert(int val){
        if(last==null){
            first=last=getNewNode(val);
            size++;
            return;
        }else{
            size++;
            last.next=getNewNode(val);
            last=last.next;
        }
    }

    //Complexity O(1)
    public boolean ifEmpty(){
        if(last==null){
            return true;
        }else{
            return false;
        }
    }

    //Complexity O(1)
    public int remove(){
        if(ifEmpty()){
            System.out.println("Queue is empty.Nothing to remove");
            return Integer.MIN_VALUE;
        }else{
            size--;
            int t=first.data;
            first=first.next;
            if(first==null){    //This condition is if there is only node then first and last will point to same
                last=null;      //In that case set last to null too
            }
                return t;
        }
    }

    //Complexity O(1)
    public int getSize(){
        return size;
    }

    //Complexity O(1)
    public int getFront(){
        if(ifEmpty()){
            System.out.println("Queue is empty.Nothing at Front");
            return Integer.MIN_VALUE;
        }else{
            return first.data;
        }
    }

    //Complexity O(1)
    public int getRear(){
        if(ifEmpty()){
            System.out.println("Queue is empty.Nothing at Rear");
            return Integer.MIN_VALUE;
        }else{
            return last.data;
        }
    }
}

public class Queue2{
    public static void main(String[] args){
        QueueLinked a=new QueueLinked();

        a.insert(12);
        a.insert(2);
        a.insert(7);
        a.insert(27);
        a.insert(18);
        a.insert(80);

        System.out.println("Size: "+a.getSize());
        System.out.println("Front: "+a.getFront());
        System.out.println("Rear: "+a.getRear());

        System.out.println("Removed Element: "+a.remove());

        System.out.println("Size: "+a.getSize());
        System.out.println("Front: "+a.getFront());
        System.out.println("Rear: "+a.getRear());
        a.insert(80);

        System.out.println("Size: "+a.getSize());
        System.out.println("Front: "+a.getFront());
        System.out.println("Rear: "+a.getRear());
    }
}
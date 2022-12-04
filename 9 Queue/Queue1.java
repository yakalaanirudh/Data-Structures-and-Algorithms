//Implementing Queue using array
class Queue{
    int MAX=5;
    int front=0;
    int rear=-1;
    int size=0;
    int[] a=new int[MAX];

    private boolean isFull(){
        if(size==MAX){
            return true;
        }else{
            return false;
        }
    }

    /*
    rearOriginal    queue
    -1              empty
    0               1 added
    1               2 added
    2               3 added
    3               4 added
    4               5 added queue full
    4               all elements removed
    0               1 added     5   5%5=0
    1               2 added     6   6%5=1
    2               3 added     7   7%5=2
    3               4 added     8   8%5=3
    4               5 added     9   9%5=4   queue full
    4               all elements removed
    0               1 added    10   10%5=0
    1               2 added    11   11%5=1
    2               3 added    12   12%5=2
    3               4 added    13   13%5=3
    4               5 added    14   14%5=4   queue full

     */
    public void insert(int val){
        if(isFull()){
            System.out.println("Queue is full.Remove some elements");
            return;
        }else {
            rear = (rear + 1) % MAX;
            size++;
            a[rear] = val;
        }
    }

    public boolean ifEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }

    /*
    front   queue               elementRemoved
    0       full
    1       first removed       after removal front is incremented to 1
    2       second removed      after removal front is incremented to 2
    3       third removed       after removal front is incremented to 3
    4       fourth removed      after removal front is incremented to 4
    0       fifth removed       after removal front is incremented to 5     5%5=0
    0       full
    1       first removed       after removal front is incremented to 6     6%5=1
    2       second removed      after removal front is incremented to 7     7%5=2
    3       third removed       after removal front is incremented to 8     8%5=3
    4       fourth removed      after removal front is incremented to 9     9%5=4
    0       fifth removed       after removal front is incremented to 10    10%5=0
     */
    public int remove(){
        if(ifEmpty()){
            System.out.println("Queue is empty.Nothing to remove");
            return Integer.MIN_VALUE;
        }else{
            front=front%MAX;
            size--;
            return a[front++];
        }
    }

    public int getSize(){
        return size;
    }

    public int getFront(){
        if(ifEmpty()){
            System.out.println("Queue is empty.Nothing at Front");
            return Integer.MIN_VALUE;
        }else{
            return a[front];
        }
    }

    public int getRear(){
        if(ifEmpty()){
            System.out.println("Queue is empty.Nothing at Rear");
            return Integer.MIN_VALUE;
        }else{
            return a[rear];
        }
    }
}

public class Queue1{
    public static void main(String[] args){
        Queue a =new Queue();

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
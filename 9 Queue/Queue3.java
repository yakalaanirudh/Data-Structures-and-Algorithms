//Here we implement priority Queue using Queue
/*
Suppose we have [12,7,10,1,8]
we need to return [12,10,8,7,1]
In priority Queue insertion O(n) deletion O(1)
 */
class PriorityQueue{
    private int MAX;
    private int[] arr;
    private int nItems;

    public PriorityQueue(){
        MAX=10;
        arr=new int[MAX];
        nItems=0;
    }

    public void insert(int val){
        int i;
        if(nItems==0){
            arr[0]=val;
            nItems++;
            return;
        }
        /*
        Now in Priority Queue we have [15,10,8,7,1](a[0],a[1],a[2],a[3],a[4]) we add 12
        for loop starts at last index 12>a[4](1)    i=4
        so a[5]=12
        next iteration                              i=3
        12>a[3](7)
        so a[4]=7
        next iteration                              i=2
        12>a[2](8)
        so a[3]=8
        next iteration                              i=1
        12>a[1](10)
        so a[2]=10
        next iteration                              i=0
        12<a[0](15) so break
        a[i+1](a1)=12
         */
        else {
            for (i = nItems - 1; i >= 0; i--) {
                if (val > arr[i]) {
                    arr[i + 1] = arr[i];
                } else {
                    break;
                }
            }
            arr[i + 1] = val;
            nItems++;
        }
    }

    public void printPriorityQueue(){
        for(int i=0;i<nItems;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public int remove(){
        return arr[--nItems];
    }

    public boolean isFull(){
        return nItems==MAX;
    }

    public boolean isEmpty(){
        return nItems==0;
    }

    public int getPeek(){
        return arr[nItems-1];
    }
}

public class Queue3{
    public static void main(String[] args){
        PriorityQueue a=new PriorityQueue();

        a.insert(12);
        a.insert(2);
        a.insert(7);
        a.insert(27);
        a.insert(18);
        a.insert(80);

        a.printPriorityQueue();

        System.out.println();
        System.out.println(a.remove());
        a.printPriorityQueue();

        System.out.println();
        System.out.println(a.remove());
        a.printPriorityQueue();
    }
}
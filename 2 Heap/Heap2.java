//Implementation of heap using Priority Queue
//Collections.reverseOrder()    for placing in reverse order
import java.util.Collections;
import java.util.PriorityQueue;

class HeapApp{
    public static void minHeap(int[] arr){
        PriorityQueue<Integer> heap=new PriorityQueue<>();

        for(int i=0;i<arr.length;i++){
            heap.add(arr[i]);
            System.out.print(heap.peek()+" ");  //This allows us to know min at every addition
        }

        System.out.println();

        for(int i=0;i<arr.length;i++){
            heap.poll();
            System.out.print(heap.peek()+" ");      //After complete filling this allows us to poll orderly
        }

        System.out.println();

    }

    public static void maxHeap(int[] arr){
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<arr.length;i++){
            heap.add(arr[i]);
            System.out.print(heap.peek()+" ");  //This allows us to know min at every addition
        }

        System.out.println();

        for(int i=0;i<arr.length;i++){
            heap.poll();
            System.out.print(heap.peek()+" ");      //After complete filling this allows us to poll orderly
        }

        System.out.println();

    }
}

public class Heap2{
    public static void main(String[] args){
        int[] arr={10,7,11,5,2,13,1,45};

        HeapApp.minHeap(arr);
        HeapApp.maxHeap(arr);
    }
}

/*
Given Array         10  7   11  5   2   13  1   45

minHeap             10  7   7   5   2   2   1   1
minHeap             2   5   7   10  11  13  45  null

maxHeap             10  10  11  11  11  13  13  45
maxHeap             13  11  10  7   5   2   1   null

The way constructed
minHeap             1   2   5   7   10  11  13  45
maxHeap             45  13  11  10  7   5   2   1
 */
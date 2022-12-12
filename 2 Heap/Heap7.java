//Return top k largest elements in ana array

import java.util.*;

class HeapApp{
    public static List<Integer> findkthLargestElementsInGivenArrayMinHeap(int[] arr,int k){

        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for(int i=0;i<k;i++){
            minHeap.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++){
            if(arr[i]>minHeap.peek()){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        List<Integer> l=new ArrayList<>();      //Add all elements from the heap to array and return the array
        for(int i=0;i<k;i++){
            l.add(minHeap.poll());
        }

        return l;
    }

    //In the below we create a max heap and poll k-1 times for peeking the kth largest element
    public static List<Integer> findkthLargestElementsInGivenArrayMaxHeap(int[] arr,int k){

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());


        for(int i=0;i<arr.length;i++){s
            maxHeap.add(arr[i]);
        }

        List<Integer> l=new ArrayList<>();
        for(int i=0;i<k;i++){
            l.add(maxHeap.poll());
        }

        return l;
    }
}


public class Heap7{
    public static void main(String[] args){
        int []arr={10,7,11,30,8,38,2,45};
        int k=3;

        System.out.println(HeapApp.findkthLargestElementsInGivenArrayMinHeap(arr,k));
        System.out.println(HeapApp.findkthLargestElementsInGivenArrayMaxHeap(arr,k));
    }
}
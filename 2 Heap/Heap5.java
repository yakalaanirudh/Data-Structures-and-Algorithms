//Find the kth smallest value in the given array
//We can do this in 2 ways


import java.util.*;
class HeapApp{
    public static int kthSmallestElementInGivenArrayMaxHeap(int[] arr,int k){
        if(arr.length<k){
            System.out.println("Invalid Case");
            return -1;
        }

        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for(int i=0;i<k;i++){
            minHeap.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++){
            if(arr[i]<minHeap.peek()){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        return minHeap.peek();
    }

    //In the below we create a min heap and poll k-1 times for peeking the kth smallest element
    public static int kthSmallestElementInGivenArrayMinHeap(int[] arr,int k){
        if(arr.length<k){
            System.out.println("Invalid Case");
            return -1;
        }

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());


        for(int i=0;i<arr.length;i++){
            maxHeap.add(arr[i]);
        }

        for(int i=0;i<k-1;i++){
            maxHeap.poll();
        }

        return maxHeap.peek();
    }
}


public class Heap5{
    public static void main(String[] args){

        int[] arr={10,7,11,30,20,38,2,45};
        int k=3;

        System.out.println(HeapApp.kthSmallestElementInGivenArrayMinHeap(arr,k));
        System.out.println(HeapApp.kthSmallestElementInGivenArrayMaxHeap(arr,k));
    }
}

/*
We can get the kth min element by creating a max heap

//if elements added in heap are less than heap size add
for(int i=0;i<k;i++){s
    minHeap.add(arr[i]);
}


else if if the element to be added is smaller than peek(min element)    poll current and add the arr[i]
for(int i=k;i<arr.length;i++){
    if(arr[i]<minHeap.peek()){
    minHeap.poll();
    minHeap.add(arr[i]);
    }
}
 */

/*
The maximum heap created is of minimum elements
So the root of the heap will be the kth largest element
 */
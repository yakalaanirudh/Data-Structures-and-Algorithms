//Find the kth largest value in the given array
//We can do this in 2 ways

//Sorting an array takes nlogn times
//Accessing an index in an array is O(K)
//So default method of creating sorting and accessing the kth element takes (nlogn +k) time

//By creating a max heap
//Max heap creation is O(n)
//Every time we pop a element for reshuffling it takes O(log n)
//So total time is O(n)+O(k*logn)

//By creating a min heap
//Max heap creation is O(n) so log k
//Every time we pop a element for reshuffling it takes O(log n)
//So total time is O(log k)+O((n-k)*logk)


import java.util.*;
class HeapApp{
    public static int kthLargestElementInGivenArrayMinHeap(int[] arr,int k){
        if(arr.length<k){
            System.out.println("Invalid Case");
            return -1;
        }

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

        return minHeap.peek();
    }

    //In the below we create a max heap and poll k-1 times for peeking the kth largest element
    public static int kthLargestElementInGivenArrayMaxHeap(int[] arr,int k){
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


public class Heap3{
    public static void main(String[] args){

        int[] arr={10,7,11,30,20,38,2,45};
        int k=3;

        System.out.println(HeapApp.kthLargestElementInGivenArrayMinHeap(arr,k));
        System.out.println(HeapApp.kthLargestElementInGivenArrayMaxHeap(arr,k));
    }
}

/*
We can get the kth max element by creating a min heap

//if elements added in heap are less than heap size add
for(int i=0;i<k;i++){
    minHeap.add(arr[i]);
}


else if if the element to be added is greater than peek(min element)    poll current and add the arr[i]
for(int i=k;i<arr.length;i++){
    if(arr[i]>minHeap.peek()){
    minHeap.poll();
    minHeap.add(arr[i]);
    }
}
 */

/*
The minimum heap created is of maximum elements
So the root of the heap will be the kth smallest element
 */

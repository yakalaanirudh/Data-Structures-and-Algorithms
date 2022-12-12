//Find the kth largest value in the given stream stream means size is not fixed

import java.util.*;

class KthLargestNumberInStream{

    PriorityQueue<Integer> minHeap=new PriorityQueue<>();

    public int add(int num,int k){
        if(minHeap.size()<k){
            minHeap.add(num);
            return minHeap.size()==k?minHeap.peek():-1;
        }

        if(num>minHeap.peek()){
            minHeap.poll();
            minHeap.add(num);
        }
        return minHeap.peek();
    }
}

public class Heap4{
    public static void main(String[] args){

        KthLargestNumberInStream a=new KthLargestNumberInStream();
        int[] arr=new int[] {10,7,11,5,27,8,9,45};
        int k=3;

        for(int i=0;i<arr.length;i++){
            System.out.println(a.add(arr[i],k));
        }
    }
}
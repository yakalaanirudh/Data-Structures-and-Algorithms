//Find the kth smallest value in the given stream stream means size is not fixed

import java.util.*;

class KthSmallestNumberInStream{

    PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());

    public int add(int num,int k){
        if(maxHeap.size()<k){
            maxHeap.add(num);
            return maxHeap.size()==k?maxHeap.peek():-1;
        }

        if(num>maxHeap.peek()){
            maxHeap.poll();
            maxHeap.add(num);
        }
        return maxHeap.peek();
    }
}

public class Heap6{
    public static void main(String[] args){

        KthLargestNumberInStream a=new KthLargestNumberInStream();
        int[] arr=new int[] {10,7,11,5,27,8,9,45};
        int k=3;

        for(int i=0;i<arr.length;i++){
            System.out.println(a.add(arr[i],k));
        }
    }
}
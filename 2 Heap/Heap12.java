//Rope cost minimum problem

import java.util.*;

class Heap{
    public static int connectRopeWithMinimumCost(int[] ropes){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for(int i=0;i<ropes.length;i++){
            minHeap.add(ropes[i]);
        }

        int minCost=0;

        while(minHeap.size()>1){
            int tempCost=minHeap.poll()+minHeap.poll();     //Poll 2 elements and get sum of two
            minCost=minCost+tempCost;

            minHeap.add(tempCost);                          //Add that sum to heap
        }
        return minCost;
    }
}
public class Heap12{
    public static void main(String[] args){
        int[] arr={3,4,7,2};
        System.out.println(Heap.connectRopeWithMinimumCost(arr));
    }
}
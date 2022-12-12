//Heap Sort Sort an array using heap

import java.util.*;

class HeapApp{
    public static void heapSort(int[] arr){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for(int i=0;i<arr.length;i++){              //Add all elements to heap
            minHeap.add(arr[i]);
        }

        for(int i=0;i<arr.length;i++){              //Poll elements from heap to array they will be in sorted order
            arr[i]=minHeap.poll();
        }
    }
}
public class Heap8{
    public static void main(String[] args){
        int[] arr={10,7,11,30,8,38,2,45};

        HeapApp.heapSort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }
}
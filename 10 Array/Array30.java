//Find max sum of all sub arrays of size k(Maximum of each k element subarray)

import java.util.*;

class ArrayProblems30 {

    public void maxOfAllSubArrays(int[] arr, int k) {
        if (arr.length == 0 || k <= 0 || k > arr.length) {
            return;
        }

        Deque<Integer> queue = new LinkedList<>();      //We can add and remove from both sides of queue
        int i;
        for (i = 0; i < k; i++) {
            //When queue is not empty and the element to be added is less than element of the index in queue pop it
            while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
                queue.removeLast();
            }

            queue.addLast(i);       //Add element to last of queue
        }
        //in the queue we add the index of the array element
        //In the queue we add from last
        for (; i < arr.length; i++) {                                   //From the iteration i reaches k(i=k)
            System.out.print(arr[queue.peek()] + " ");                   //At that point max is queue(peek)

            //When queue is not empty and and difference of iterators is greater than queue peek
            //Suppose k=3 and we are adding 4th element(index 3) then first element(0index) has to be popped
            //i-k=3-3=0>=0
            //So we pop first element(0 index)
            while (!queue.isEmpty() && i - k >= queue.peek()) {
                queue.removeFirst();                    //Pop first element
            }

            //When queue is not empty and element to be added is > element at queue last element
            //We remove that element index at last of queue
            while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
                queue.removeLast();                                             //Remove last element from queue
            }

            queue.addLast(i);               //Add the latest index into queue last
        }
        System.out.println(arr[queue.peek()]);      //For the last sub window highest is queue.peek
    }
}


public class Array30{
    public static void main(String[] args){
        ArrayProblems30 a=new ArrayProblems30();

        int[] arr={2,5,4,3,1,7};
        int k=3;
        a.maxOfAllSubArrays(arr,k);             //  5   5   4   7   (Maximum of every k element subarray)
    }
}

/*
In second method we place the sum from start to every index in a map lets say totalSumTillNow

At every index we check if required (totalSumTillNow-sum) is in map

if it is then we got the sub array
 */



//The below is own method using treemap
/*
import java.util.*;

class Practice1{
    public void lets(int[] arr,int k){

        TreeMap<Integer,Integer> t=new TreeMap<Integer, Integer>();

        for(int i=0;i<arr.length-k;i++){
            int indexsum=arr[i]+arr[i+1]+arr[i+2];
            t.put(i,indexsum);
        }

        System.out.println(t);
    }
}




public class Practice{
    public static void main(String[] args){
        Practice1 a=new Practice1();

        int[] arr={2,5,4,3,1,7,11,23,25,17,26,10};
        int k=3;
        a.lets(arr,k);
    }
}
 */
//Find 1st occurence of a value if adjacent values differ by 1

import java.util.HashSet;
import java.util.Set;

class ArrayProblems17{
    public int findFirstOccurenceIfAdjacentValueDifferBy1(int[] arr,int val){
        if(arr.length==0){
            return -1;
        }

        int start=0;

        while(start<arr.length){
            if(arr[start]==val){
                return start;
            }

            int diff=Math.abs(arr[start]-val);
            start=start+diff;
        }

        return -1;
    }


}

public class Array17{
    public static void main(String[] args){
        ArrayProblems17 a=new ArrayProblems17();

        int arr[]={7,6,7,6,7,6,5,4,5,4,3,2,1,2,3};

        System.out.println(a.findFirstOccurenceIfAdjacentValueDifferBy1(arr,2));
    }
}

/*
[7,6,7,6,7,6,5,4,5,4,3,2,1,2,3]

7-2=5
7,6,7,6,7,6

6-2=4
5,4,5,4

4-2=2
4,3,2

 */
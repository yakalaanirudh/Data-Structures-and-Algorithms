//Find max sum with a subarray of length k

import java.util.*;

class ArrayProblems27{

    public int findSubArraywithSizeKMaxSum(int[] arr,int k){
        if(arr.length==0 ||k<=0){
            System.out.println("Array is empty");
            return -1;
        }

        int sum=0,i;

        for(i=0;i<k;i++){
            sum=sum+arr[i];
        }

        int max_sum=sum;
        int start=0;

        for(int j=i;j<arr.length;j++){
            sum=sum+arr[j]-arr[start++];        //Subtract start index value and increment start by 1
            if(sum>max_sum){
                max_sum=sum;
            }
        }
        return max_sum;
    }
}


public class Array27{
    public static void main(String[] args){
        ArrayProblems27 a=new ArrayProblems27();

        int[] arr={10,7,10,11,10,7,6,5};
        a.findSubArraywithSizeKMaxSum(arr,7);
    }
}

/*
In second method we place the sum from start to every index in a map lets say totalSumTillNow

At every index we check if required (totalSumTillNow-sum) is in map

if it is then we got the sub array
 */
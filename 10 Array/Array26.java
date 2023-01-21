//Find sub-array whose sum is equal to given sum

import java.util.*;

class ArrayProblems26{

    public void subArrayEqualSum(int[] arr,int sum){
        if(arr.length==0){
            System.out.println("Array is empty");
            return;
        }

        int start,end,window_Sum;
        start=end=0;
        window_Sum=0;

        while(end<arr.length){
            window_Sum=window_Sum+arr[end];

            if(window_Sum==sum){
                System.out.println("Start Index: "+start+", End Index: "+end);
                return;
            }

            while(window_Sum>sum&&start<=end){
                window_Sum=window_Sum-arr[start++];         //Subtract start index value and increment start by 1

                if(window_Sum==sum){
                    System.out.println("Start Index: "+start+", End Index: "+end);
                    return;
                }
            }
        end++;
        }

        System.out.println("There is no such sub-array");
    }



    public void subArrayEqualSum2(int[] arr,int sum){
        if(arr.length==0){
            System.out.println("Array is empty");
            return;
        }

        int end,totalSumTillNow;
        end=0;
        totalSumTillNow=0;

        Map<Integer,Integer> map=new HashMap<>();

        while(end<arr.length){
            totalSumTillNow=totalSumTillNow+arr[end];

            if(totalSumTillNow==sum){
                System.out.println("Start Index: "+0+", End Index: "+end);
                return;
            }

            int windowSum=totalSumTillNow-sum;

            if(map.containsKey(windowSum)){
                int start=map.get(windowSum);
                System.out.println("Start Index: "+(start+1)+", End Index: "+end);
                return;
            }

            map.put(totalSumTillNow,end++);
        }
    }
}


public class Array26{
    public static void main(String[] args){
        ArrayProblems26 a=new ArrayProblems26();

        int[] arr={10,7,10,11,10,7,6,5};
        a.subArrayEqualSum(arr,7);
    }
}

/*
In second method we place the sum from start to every index in a map lets say totalSumTillNow

At every index we check if required (totalSumTillNow-sum) is in map

if it is then we got the sub array
 */
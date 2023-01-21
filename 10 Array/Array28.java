//Find smallest sub-array whose sum is equal to given sum

import java.util.*;

class ArrayProblems28{

    public int smallestSubArrayEqualSum(int[] arr,int sum){
        if(arr.length==0){
            System.out.println("Array is empty");
            return -1;
        }

        int start,end,window_Sum;
        start=end=0;
        window_Sum=0;
        int smallestLength=Integer.MAX_VALUE;

        while(end<arr.length){
            window_Sum=window_Sum+arr[end];

            if(window_Sum==sum){
                System.out.println("Start Index: "+start+", End Index: "+end);
                smallestLength=Math.min(smallestLength,end-start+1);
            }

            while(window_Sum>sum&&start<=end){
                window_Sum=window_Sum-arr[start++];         //Subtract start index value and increment start by 1

                if(window_Sum==sum){
                    System.out.println("Start Index: "+start+", End Index: "+end);
                    smallestLength=Math.min(smallestLength,end-start+1);
                }
            }
            end++;
        }

        return smallestLength !=Integer.MAX_VALUE?smallestLength:-1;
    }



    public int smallestSubArrayEqualSum2(int[] arr,int sum){
        if(arr.length==0){
            System.out.println("Array is empty");
            return -1;
        }

        int end,totalSumTillNow,smallestLength;
        end=0;
        totalSumTillNow=0;
        smallestLength=Integer.MAX_VALUE;

        Map<Integer,Integer> map=new HashMap<>();

        while(end<arr.length){
            totalSumTillNow=totalSumTillNow+arr[end];

            if(totalSumTillNow==sum){
                System.out.println("Start Index: "+0+", End Index: "+end);
                smallestLength=Math.min(smallestLength,end+1);
            }

            int windowSum=totalSumTillNow-sum;

            if(map.containsKey(windowSum)){
                int start=map.get(windowSum);
                System.out.println("Start Index: "+(start+1)+", End Index: "+end);
                smallestLength=Math.min(smallestLength,end+1);
            }

            map.put(totalSumTillNow,end++);
        }
        return smallestLength !=Integer.MAX_VALUE?smallestLength:-1;
    }
}


public class Array28{
    public static void main(String[] args){
        ArrayProblems28 a=new ArrayProblems28();

        int[] arr={10,7,10,11,10,7,6,5};
        a.smallestSubArrayEqualSum(arr,7);
    }
}

/*
In second method we place the sum from start to every index in a map lets say totalSumTillNow

At every index we check if required (totalSumTillNow-sum) is in map

if it is then we got the sub array
 */
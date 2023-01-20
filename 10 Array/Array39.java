//Find three numbers with sum closest to required sum

import java.util.*;

class ArrayProblems39 {
    public int findTripletscloser(int[] arr, int targetSum) {
        Arrays.sort(arr);

        int minDifference=Integer.MAX_VALUE;
        int closestSum=Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {

            int start = i + 1;
            int end = arr.length - 1;

            while(start<end){
                int TripletSum=arr[i]+arr[start]+arr[end];

                if(Math.abs(targetSum-TripletSum)<=minDifference && TripletSum<closestSum){
                    minDifference=Math.abs(targetSum-TripletSum);
                    closestSum=TripletSum;
                }

                if(TripletSum==targetSum){
                    return TripletSum;
                }else if(TripletSum<targetSum){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return closestSum;
    }
}

public class Array39{
    public static void main(String[] args) {
        ArrayProblems39 a = new ArrayProblems39();

        int arr[] = {1,2,-3,4,-2,-1};

        System.out.println(a.findTripletscloser(arr,1));
    }
}

/*
target sum=5
lower sum=3
higher sum=7
if(Math.abs(targetSum-TripletSum)<=minDifference && TripletSum<closestSum){     lower value
if(Math.abs(targetSum-TripletSum)<=minDifference && TripletSum>closestSum){     higher value
if(Math.abs(targetSum-TripletSum)<=minDifference &&){                           both values
 */
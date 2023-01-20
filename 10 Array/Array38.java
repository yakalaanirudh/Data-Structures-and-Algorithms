//Find three numbers with sum less than required sum

import java.util.*;

class ArrayProblems38 {
    public int findTripletsless(int[] arr, int targetSum) {
        Arrays.sort(arr);

        int TripletCount=0;

        for (int i = 0; i < arr.length - 2; i++) {
            //int sum = targetSum - arr[i];

            int start = i + 1;
            int end = arr.length - 1;

            while (start < end) {
                int t = arr[i]+arr[start] + arr[end];

                if (t < targetSum) {
                    TripletCount=TripletCount+end-start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return TripletCount;
    }
}

public class Array38{
    public static void main(String[] args) {
        ArrayProblems38 a = new ArrayProblems38();

        int arr[] = {1,2,-3,4,-2,-1};

        System.out.println(a.findTripletsless(arr,1));
    }
}

/*
TripletCount=TripletCount+end-start;

Because values are in sorted order if the sum is less the next sum by reducing end will also be less
 */
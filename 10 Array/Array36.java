//Find three numbers with required sum

import java.util.*;

class ArrayProblems36 {
    public List<List<Integer>> findTriplets(int[] arr, int targetSum) {
        Arrays.sort(arr);

        List<List<Integer>> allTriplets = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            int sum = targetSum - arr[i];

            int start = i + 1;
            int end = arr.length - 1;

            while (start < end) {
                int t = arr[start] + arr[end];

                if (t == sum) {
                    allTriplets.add(Arrays.asList(arr[start], arr[end], arr[i]));
                    start++;
                    end--;
                } else if (t < sum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return allTriplets;
    }
}

public class Array36{
    public static void main(String[] args) {
        ArrayProblems36 a = new ArrayProblems36();

        int arr[] = {1,2,-3,4,-2,-1};

        System.out.println(a.findTriplets(arr,1));
    }
}

/*
We save all triplets in a list of lists(which conatin the triad)

We sort the array
we iterate with all indices in the array
lets say we start with 0th index;
We subtract target sum minus this index value lets say it is required

Then we take two values 1st index and last index and calculate their sum
If sum==required we add to list
If sum<required we increment start
if sum>required we decrement end
 */
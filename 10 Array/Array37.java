//Find four numbers with required sum

import java.util.*;

class ArrayProblems37 {
    public List<List<Integer>> findQuads(int[] arr, int targetSum) {
        Arrays.sort(arr);

        List<List<Integer>> allQuads = new ArrayList<>();

        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; i < arr.length - 2; j++) {
                int sum = targetSum - (arr[i] + arr[j]);

                int start = j + 1;
                int end = arr.length - 1;

                while (start < end) {
                    int t = arr[start] + arr[end];

                    if (t == sum) {
                        allQuads.add(Arrays.asList(arr[start], arr[end], arr[i], arr[j]));
                        start++;
                        end--;
                    } else if (t < sum) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
            return allQuads;
    }
}

public class Array37{
    public static void main(String[] args) {
        ArrayProblems37 a = new ArrayProblems37();

        int arr[] = {1,2,-3,4,-2,-1};

        System.out.println(a.findQuads(arr,1));
    }
}

/*
We save all quads in a list of lists(which conatin the quad)

We sort the array
we iterate with all indices in the array
lets say we start with 0th index and 1st index;
We subtract target sum minus these two indices value lets say it is required

Then we take two values 1st index and last index and calculate their sum
If sum==required we add to list
If sum<required we increment start
if sum>required we decrement end
 */
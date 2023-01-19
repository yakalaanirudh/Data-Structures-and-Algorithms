//Union of two Unsorted arrays

import java.util.*;

class ArrayProblems22 {
    public void unionOfTwoUnsortedArray(int[] arr1, int[] arr2, Set<Integer> finalList) {

        int i = 0;
        int j = 0;

        //Set<Integer> finalList =new HashSet<>();
        while (i < arr1.length) {
            finalList.add(arr1[i++]);
        }

        while (j < arr2.length) {
            finalList.add(arr1[j++]);
        }

    }
}

public class Array22{
    public static void main(String[] args){
        ArrayProblems22 a=new ArrayProblems22();

        int arr1[]={2,4,4,5,6,7,7};
        int arr2[]={1,2,2,2,3,4,5,7};
        Set<Integer> finalUnionArray =new HashSet<>();

        a. unionOfTwoUnsortedArray(arr1,arr2,finalUnionArray);
        System.out.println(finalUnionArray);
    }
}
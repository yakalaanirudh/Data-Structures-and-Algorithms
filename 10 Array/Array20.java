//Union of two sorted arrays

import java.util.*;

class ArrayProblems20 {
    public void intersectionOfTwoSortedArray(int[] arr1, int[] arr2, List<Integer> finalList) {

        int i = 0;
        int j = 0;

        //The inner while statements are to skip repeated values
        while (i < arr1.length && j < arr2.length) {
            while ((i < arr1.length - 1) && (arr1[i] == arr1[i + 1])) {
                i++;
            }

            while ((j < arr2.length - 1) && (arr1[j] == arr2[j + 1])) {
                j++;
            }
        }

        if (arr1[i] < arr2[j]) {
            finalList.add(arr1[i++]);
        } else if (arr1[i] > arr2[j]) {
            finalList.add(arr1[i++]);
        } else {
            finalList.add(arr1[i]);
            i++;
            j++;
        }
    }
}

public class Array20{
    public static void main(String[] args){
        ArrayProblems20 a=new ArrayProblems20();

        int arr1[]={2,4,4,5,6,7,7};
        int arr2[]={1,2,2,2,3,4,5,7};
        List<Integer> finalUnionArray =new ArrayList<>();

        a.intersectionOfTwoSortedArray(arr1,arr2,finalUnionArray);
        System.out.println(finalUnionArray);
    }
}
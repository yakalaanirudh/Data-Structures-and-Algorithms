//Intersection of two sorted arrays

import java.util.*;

class ArrayProblems21 {
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
            i++;
        } else if (arr1[i] > arr2[j]) {
            j++;
        } else {
            finalList.add(arr1[i]);
            i++;
            j++;
        }
    }
}

public class Array21{
    public static void main(String[] args){
        ArrayProblems21 a=new ArrayProblems21();

        int arr1[]={2,2,2,3,3,4,7,8};
        int arr2[]={1,2,4,4,6,6,7,8,10};
        List<Integer> finalIntersectionArray =new ArrayList<>();

        a.intersectionOfTwoSortedArray(arr1,arr2,finalIntersectionArray);
        System.out.println(finalIntersectionArray);
    }
}
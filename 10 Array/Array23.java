//Intersection of two Unsorted arrays

import java.util.*;

class ArrayProblems23 {
    public void intersectionOfTwoUnsortedArray(int[] arr1, int[] arr2, Set<Integer> finalIntersection) {

        int i = 0;
        int j = 0;

        Set<Integer> tempSet =new HashSet<>();
        while (i < arr1.length) {
            tempSet.add(arr1[i++]);
        }

        while (j < arr2.length) {
            if(tempSet.contains(arr2[j])) {
                finalIntersection.add(arr1[j++]);
            }
            j++;
        }

    }
}

public class Array23{
    public static void main(String[] args){
        ArrayProblems23 a=new ArrayProblems23();

        int arr1[]={2,2,2,3,3,4,7,8};
        int arr2[]={1,2,4,4,6,6,7,8,10};
        Set<Integer> finalIntersection =new HashSet<>();

        a.intersectionOfTwoUnsortedArray(arr1,arr2,finalIntersection);
        System.out.println(finalIntersection);
    }
}
//Cyclic sort of an array       This complexity is O(n) and space complexity is O(1)

import java.util.*;

class ArrayProblems43 {
    public void cyclicSort(int[] arr) {
        if(arr.length<=1){
            return;
        }

        int i=0;
        while(i<arr.length){
            if(arr[i]-1!=i){
                int otherIndex=arr[i]-1;

                int x=arr[i];
                arr[i]=arr[otherIndex];
                arr[otherIndex]=x;
            }else{
                i++;
            }
        }
    }
}

public class Array43{
    public static void main(String[] args) {
        ArrayProblems43 a = new ArrayProblems43();

        int arr[] = {1,2,3,4,5,6,7,8,9,10,11};

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i] + " ");
        }
    }
}

/*
Ideal position of a value is index+1
Values [1,2,3,4,5,6,7,8,9,10,11]
Index  [0,1,2,3,4,5,6,7,8,9,10]

if  a {value} at index(i) is not {i+1} we swap the value for index(value-1)

[3,4,6,2,1,5]
[6,4,3,2,1,5]
[5,4,3,2,1,6]
[1,4,3,2,5,6]
[1,2,3,4,5,6]
 */
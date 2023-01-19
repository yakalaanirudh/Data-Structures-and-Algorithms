//Multiplication matches a value

import java.util.*;

class ArrayProblems49{

    //First method
    //We create a new array and populate it in reverse
    //Time Complexity:o(n)  Space Compexity:O(n)
    public int[] reverseAnArray1(int[] arr,int n){
        if(arr.length<=1){
            return arr;
        }

        int[] new_array=new int[n];
        int j=n;

        for(int i=0;i<n;i++){
            new_array[j-i-1]=arr[i];
        }

        return new_array;
    }

    //Second method
    //Here we just swap the elements left with right
    //Time Complexity:o(n)  Space Compexity:O(1)    Because we return the same array
    public void reverseAnArray2(int[] arr,int n){
        if(arr.length<=1){
            return;
        }

        int t=0;

        for(int i=0;i<n/2;i++){
            t=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=t;
        }
    }
}

public class Array49{
    public static void main(String[] args){
        ArrayProblems49 a=new ArrayProblems49();

        int arr[]={1,2,3,4,5,6,7};

        int[] resultant_array=a.reverseAnArray1(arr,arr.length);

        for(int i=0;i<resultant_array.length;i++){
            System.out.println(resultant_array[i]+" ");
        }

    }
}
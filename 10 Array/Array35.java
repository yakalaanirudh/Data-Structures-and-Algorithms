//Square sort of a sorted array
import java.util.*;

class ArrayProblems35{
    public int[] squaresort(int[] arr){

        int[] squareArr=new int[arr.length];
        int i=arr.length-1;

        int start=0;
        int end=arr.length-1;

        while(start<=end){
            if(arr[start]*arr[start]>arr[end]*arr[end]){    //If the square of start values is larger than end values
                squareArr[i--]=arr[start]*arr[start];       //We place that value at the end of the resulting array
                start++;                                    //We increment start
            }else{
                squareArr[i--]=arr[end]*arr[end];   //Else,We place that value at the end of the resulting array
                end--;                              //We decrement start
            }
        }

        return squareArr;
    }
}

public class Array35{
    public static void main(String[] args){
        ArrayProblems35 a=new ArrayProblems35();

        int arr[]={-4,-2,-1,3,5};       //[1,4,9,16,25]

        System.out.println(a.squaresort(arr));
    }
}

/*
Initially the array given to us is sorted but has negative values
 */
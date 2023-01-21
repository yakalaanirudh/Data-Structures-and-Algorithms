//Max Multiplication of any two numbers(Sorted array)

import java.util.*;

class ArrayProblems25{

    public int MaxProductOfTwoNumbers(int[] arr){
        if(arr.length<2){
            return -1;
        }

        if(arr.length==2){
            return arr[0]*arr[1];
        }

        int smallest            =arr[0]<arr[1] ?arr[0]:arr[1];
        int secondsmallest      =arr[0]>arr[1] ?arr[0]:arr[1];
        int greatest            =arr[0]>arr[1] ?arr[0]:arr[1];
        int secondgreatest      =arr[0]<arr[1] ?arr[0]:arr[1];

        for(int i=0;i<arr.length;i++) {

            if (arr[i] < smallest) {
                secondsmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] < secondsmallest) {
                secondsmallest = arr[i];
            }

            if (arr[i] > greatest ) {
                secondgreatest = greatest ;
                smallest = arr[i];
            } else if (arr[i] > secondgreatest) {
                secondgreatest = arr[i];
            }
        }

        int firstTwoMultiplication=smallest*secondsmallest;
        int lastTwoMultiplication=greatest*secondgreatest;

        return firstTwoMultiplication>lastTwoMultiplication? firstTwoMultiplication:lastTwoMultiplication;
    }
}


public class Array25{
    public static void main(String[] args){
        ArrayProblems25 a=new ArrayProblems25();

        int[] arr={10,7,10,11,10,7,6,5};
        a.MaxProductOfTwoNumbers(arr);
    }
}

/*
[-7,-3,1,3,5,7]

Product of two negative numebrs can be greater than two positive so we find two smallest numbers too
 */
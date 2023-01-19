//Segregate odd and even numbers in an array

import java.util.*;

class ArrayProblems52{
    public void seperateEvenOddNumbers(int[] arr){
        if(arr.length<=1){
            return;
        }

        int left,right;
        left=0;
        right=arr.length-1;

        while(left<right){
            while(arr[left]%2==0 && left<right){
                left++;
            }
            while(arr[left]%2!=0 && left<right){
                right--;
            }
        }

        if(left<right){
            int x=arr[left];
            arr[left]=arr[right];
            arr[right]=x;

            left++;
            right--;
        }
    }
}

public class Array52{
    public static void main(String[] args){
        ArrayProblems52 a=new ArrayProblems52();

        int arr[]={1,2,4,3,5,7,8,6};

        a.seperateEvenOddNumbers(arr);
    }
}

/*
We keep evens in the left and odds to the right

We start with two indices left and right
When left  index is even we increment
When right  index is odd we decrement
if not
When left index is odd we swap with the element at right index as it has even
*/
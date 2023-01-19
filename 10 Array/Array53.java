//Segregate 0s and 1s numbers in an array

import java.util.*;

class ArrayProblems53{
    public void seperatezerosandones(int[] arr){
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

public class Array53{
    public static void main(String[] args){
        ArrayProblems53 a=new ArrayProblems53();

        int arr[]={0,1,1,0,0,0,1,1,0,1};

        a.seperatezerosandones(arr);
    }
}

/*
We keep 0s in the left and 1s to the right

We start with two indices left and right
When left  index is 0 we increment
When right  index is 1 we decrement
if not
When left index is 1 we swap with the element at right index as it has 0
*/
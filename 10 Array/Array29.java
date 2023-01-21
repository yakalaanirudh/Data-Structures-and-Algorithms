//Find max sum of all sub arrays of size k

import java.util.*;

class ArrayProblems29 {

    public int LargestSubArraySum(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty");
            return -1;
        }

        boolean ifPositiveExists=false;
        int max_element=Integer.MIN_VALUE;
        int max_sum=Integer.MIN_VALUE;
        int sum=0;


        for(int i=0;i<arr.length;i++){
            if(arr[i]>=0){
                ifPositiveExists=true;
            }

            max_element=Math.max(arr[i],max_element);
            sum=sum+arr[i];

            if(sum<0){
                sum=0;
                continue;
            }

            max_sum=Math.max(max_sum,sum);
        }

        return ifPositiveExists?max_sum:max_element;
    }
}


public class Array29{
    public static void main(String[] args){
        ArrayProblems29 a=new ArrayProblems29();

        int[] arr={2,5,4,3,1,7};
        System.out.println(a.LargestSubArraySum(arr));
    }
}

/*
//We use max_element in cases like if all elements are negative then max sum is the single most lowest number

//We start iterating from start and calculate till_there sum if at anypoint till_there sum becomes zero
//we set the sum to zero and proceed from next index

//After that we compare between max sum and till there sum to get max sum
 */






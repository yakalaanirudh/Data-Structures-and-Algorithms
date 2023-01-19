//Find missing number in 1 to n range in a unsorted Array

class ArrayProblems11{
    public int findMissingUnsortedArray(int[] arr,int n){
        int sum=(n*(n+1))/2;

        for(int i=0;i<arr.length;i++){
            sum=sum-arr[i];
        }

        return sum;
    }
}


public class Array11{
    public static void main(String[] args){
        ArrayProblems11 a=new ArrayProblems11();

        int arr[]={2,4,1,3,6,7,8};
        System.out.println(a.findMissingUnsortedArray(arr,arr.length+1));
    }
}

/*
we are given an array starting from 1 to n numbers with 1 number missing we have to find that number

We find the length of array lets say n
We find sum of n numbers
We subtract each element of the array from the sum
The resulting number is the missing number

 */
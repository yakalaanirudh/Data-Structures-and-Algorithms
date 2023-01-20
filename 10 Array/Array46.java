//Find Duplicate value in 1 to n+1 range


import java.util.*;

class ArrayProblems46 {
    public int findDuplicate(int[] arr) {
        if(arr.length==0){
            return -1;
        }

        int i=0;
        while(i<arr.length){
            if(arr[i]!=arr[arr[i]-1]){
                int otherIndex=arr[i]-1;

                int x=arr[i];
                arr[i]=arr[otherIndex];
                arr[otherIndex]=x;
            }else{
                i++;
            }
        }

        return arr[arr.length-1];
    }
}

public class Array46{
    public static void main(String[] args) {
        ArrayProblems46 a = new ArrayProblems46();

        int arr[] = {2,3,4,2,1};

        System.out.println(a.findDuplicate(arr));


    }
}

/*
We sort the array using cyclic sort

After that we loop through the array if at any index the value is not equal to

[2,3,4,2,1] 0 index
[3,2,4,2,1] 0 index
[4,2,3,2,1] 0 index
[2,2,3,4,1] 1 index
In next iteration
            if(arr[i]!=arr[arr[i]-1]){
            arr[1]=2
            arr[arr[1]-1]       =arr[2-1]   =arr[1]     =2
The condition fails
So we proceed to next iteration till while loop is completely executed
[1,2,3,4,2] 1 index

The duplicate is pushed to end
then
we return the last value
*/

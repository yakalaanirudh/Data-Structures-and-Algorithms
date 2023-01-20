//Find missing numbers in 1 to n+1 range


import java.util.*;

class ArrayProblems44 {
    public int findMissingNumber(int[] arr) {
        if(arr.length==0){
            return -1;
        }

        int i=0;
        while(i<arr.length){
            if(arr[i]<=arr.length && arr[i]!=i+1){
                int otherIndex=arr[i]-1;

                int x=arr[i];
                arr[i]=arr[otherIndex];
                arr[otherIndex]=x;
            }else{
                i++;
            }
        }

        for(i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }

        return -1;
    }
}

public class Array44{
    public static void main(String[] args) {
        ArrayProblems44 a = new ArrayProblems44();

        int arr[] = {3,2,4,6,1};

        System.out.println(a.findMissingNumber(arr));


    }
}

/*
We sort the array using cyclic sort

After that we loop through the array if at any index the value is not equal to

[3,2,4,6,1] 0 index
[4,2,3,6,1] 0 index
[6,2,3,4,1] 0 index
[6,2,3,4,1] 1 index
[6,2,3,4,1] 2 index
[6,2,3,4,1] 3 index
[1,2,3,4,6] 4 index

now when we loop through arr[4]!=5 so we return 5
*/

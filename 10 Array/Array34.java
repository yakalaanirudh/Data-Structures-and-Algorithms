//Remove all duplicates in a sorted array
import java.util.*;

class ArrayProblems34{
    public int removeAllDuplicates(int[] arr){
        if(arr.length<=1){
            return arr.length;
        }

        int start=1;

        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){               //If an element is not equal to its predecessor
                arr[start++]=arr[i];            //We increment start value and place that value at that index
            }
        }
        return start;                           //We return the number of unique elements
    }

}

public class Array34{
    public static void main(String[] args){
        ArrayProblems34 a=new ArrayProblems34();

        int arr[]={1,4,4,4,5,6,7,7,8};

        System.out.println(a.removeAllDuplicates(arr));
    }
}

/*
We are given an array so we cant change its size
So what we do is we place all unique elements at the start and give that length


*/
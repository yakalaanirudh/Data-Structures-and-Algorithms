//Find first repeating value in an array

import java.util.*;

class ArrayProblems19{
    public int firstRepeatingValue(int[] arr){
        if(arr.length==0){
            return -1;
        }

        Set<Integer> s=new HashSet<>();

        int firstRepeatingValue=Integer.MIN_VALUE;

        for(int i=arr.length-1;i>=0;i--){
            if(s.contains(arr[i])){
                firstRepeatingValue=arr[i];
            }else{
                s.add(arr[i]);
            }
        }

        return firstRepeatingValue;
    }


}

public class Array19{
    public static void main(String[] args){
        ArrayProblems19 a=new ArrayProblems19();

        int arr[]={2,3,4,4,3,5,7};
        System.out.println(a.firstRepeatingValue(arr));
    }
}
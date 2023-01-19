//Check if there exists a pair which matches the given sum

import java.util.*;

class ArrayProblems16{
    public boolean ifPairExistsWithGivenSum(int[] arr,int val){
        if(arr.length==0){
            return false;
        }


        Set<Integer> s=new HashSet<>();

        for(int i=0;i<arr.length;i++){
            if(s.contains(val-arr[i])){
                return true;
            }else{
                s.add(arr[i]);
            }
        }

        return false;
    }


}

public class Array16{
    public static void main(String[] args){
        ArrayProblems16 a=new ArrayProblems16();

        int arr[]={12,3,5,1,9};

        System.out.println(a.ifPairExistsWithGivenSum(arr,10));
    }
}
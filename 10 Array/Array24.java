//Multiplication matches a value

import java.util.*;

class ArrayProblems24{
    public boolean ifPairExistsWithGivenProduct(int[] arr,int val){
        if(arr.length==0){
            return false;
        }


        Set<Integer> s=new HashSet<>();

        for(int i=0;i<arr.length;i++){
            if(val%arr[i]==0 && s.contains(val/arr[i])){
                return true;
            }else{
                s.add(arr[i]);
            }
        }

        return false;
    }


}

public class Array24{
    public static void main(String[] args){
        ArrayProblems24 a=new ArrayProblems24();

        int arr[]={12,3,5,1,9};

        System.out.println(a.ifPairExistsWithGivenProduct(arr,10));
    }
}
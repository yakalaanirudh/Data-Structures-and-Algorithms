//Find the first k missing positive number

import java.util.*;

class ArrayProblems51{
    public List<Integer> firstKMissingPositive(int[] arr,int k){
        if(arr.length==0 ||k<1){
            return new ArrayList<>();
        }

        int i=0;

        while(i<arr.length){
            if(arr[i]>0 && arr[i]<=arr.length &&arr[i]!=arr[arr[i]-1]){
                int otherIndex=arr[i]-1;

                int x=arr[i];
                arr[i]=arr[otherIndex];
                arr[otherIndex]=x;
            }else{
                i++;
            }
        }

        List<Integer> missing =new ArrayList<Integer>();
        HashSet<Integer> otherNumber =new HashSet<Integer>();

        //This for loop is finding numbers that are lesser than arr.length
        for(i=0;i<arr.length & missing.size()< k;i++){
            if(arr[i]!=i+1){
                missing.add(i+1);
                otherNumber.add(arr[i]);
            }
        }

        //This for loop is finding numbers that are greater than arr.length
        for(int j=i;missing.size()< k;j++){
            if(!otherNumber.contains(j+1)){
                missing.add(j+1);
            }
        }

        return missing;
    }
}


public class Array51{
    public static void main(String[] args){
        ArrayProblems51 a=new ArrayProblems51();

        int[] arr={-2,11,1,-3,2,8,4};

        System.out.println(a.firstKMissingPositive(arr,5));
    }
}

/*
[-2,11,1,-3,2,8,4]

if(arr[i]>0 && arr[i]<=arr.length &&arr[i]!=arr[arr[i]-1])
We ignore numbers less than and greater than arr.length and numbers that are repeated
[-2,11,1,-3,2,8,4]     Given Array
[1,11,-2,-3,2,8,4]
[1,2,-2,-3,11,8,4]
[1,2,-2,4,11,8,-2]

When we iterate through it again we see that -2 3 should be present so we return index+1

missing=[3,5,6,7]
otherValue=[-2,11,8,-2]
*/
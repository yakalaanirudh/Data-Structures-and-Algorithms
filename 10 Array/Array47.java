//Find Duplicate value in 1 to n+1 range


import java.util.*;

class ArrayProblems47 {
    public List<List<Integer>> findAllDuplicatesAndMissing(int[] arr) {
        if(arr.length==0){
            return new ArrayList<>();
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

        List<Integer> missingValues=new ArrayList<>();
        List<Integer> duplicateValues=new ArrayList<>();

        for(i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                missingValues.add(i+1);
                duplicateValues.add(arr[i]);
            }
        }

        List<List<Integer>> result =new ArrayList<>();
        result.add(missingValues);
        result.add(duplicateValues);

        return result;
    }
}

public class Array47{
    public static void main(String[] args) {
        ArrayProblems47 a = new ArrayProblems47();

        int arr[] = {2,3,4,2,1};

        System.out.println(a.findAllDuplicatesAndMissing(arr));


    }
}


//Find missing numbers in 1 to n+1 range


import java.util.*;

class ArrayProblems45 {
    public List<Integer> corruptPair(int[] arr) {
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

        for(i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                return new ArrayList<>(Arrays.asList(i+1,arr[i]));
            }
        }

        return new ArrayList<>();
    }
}

public class Array45{
    public static void main(String[] args) {
        ArrayProblems45 a = new ArrayProblems45();

        int arr[] = {4,3,4,5,1};

        System.out.println(a.corruptPair(arr));


    }
}

/*
We sort the array using cyclic sort

After that we loop through the array if at any index the value is not equal to

[4,3,4,5,1] 0 index
[5,3,4,4,1] 0 index
[1,3,4,4,5] 0 index
[1,4,3,4,5] 1 index
In next iteration
            if(arr[i]!=arr[arr[i]-1]){
            arr[1]=4
            arr[arr[1]-1]       =arr[4-1]   =arr[3]     =4
The condition fails
So we proceed to next iteration till while loop is completely executed

then
a[1]!=2 so we return{2,4}
*/

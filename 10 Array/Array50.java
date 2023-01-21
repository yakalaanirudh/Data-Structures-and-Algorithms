//Find the first missing positive number

class ArrayProblems50{
    public int firstMissingPositive(int[] arr){
        if(arr.length==0){
            return 1;
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

        for(i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }

        return arr.length+1;
    }
}


public class Array50{
    public static void main(String[] args){
        ArrayProblems50 a=new ArrayProblems50();

        int[] arr={-2,11,1,-3,2,10,4};

        System.out.println(a.firstMissingPositive(arr));
    }
}

/*
[-2,11,1,-3,2,10,4]

if(arr[i]>0 && arr[i]<=arr.length &&arr[i]!=arr[arr[i]-1])
We ignore numbers less than and greater than arr.length and numbers that are repeated
[-2,11,1,-3,2,10,4]     Given Array
[1,11,-2,-3,2,10,4]
[1,2,-2,-3,11,10,4]
[1,2,-2,4,11,10,-2]

When we iterate through it again we see taht -2 3 should be present so we return index+1
 */
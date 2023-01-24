//Minimum jumps to reach last value in an array

class minJumpsEnd{
    public int mintotalJumpsToEnd(int[] arr){
        if(arr.length==0){return -1;}

        int[] minJumps=new int[arr.length];

        //Initially we set the min value to reach each index to infinity
        for(int i=0;i<arr.length;i++){
            minJumps[i]=Integer.MAX_VALUE;
        }

        minJumps[0]=0;      //Then we set first index to 0

        /*
        For each index i
        In inner loop
            for each index j  which can be reached from ith index

            The value for that index is min of(the value in that index and the value from in ith index +1
            +1 because we take one jump from i index to reach j index

         */

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=i+arr[i] &&j<arr.length;j++){
                minJumps[j]=Math.min(minJumps[j],1+minJumps[i]);
            }
        }

        return minJumps[arr.length-1];
    }


}


public class DP19{
    public static void main(String[] args){
        minJumpsEnd a=new minJumpsEnd();

        int[] arr={1,2,1,3,2,1,2,1};
        System.out.println(a.mintotalJumpsToEnd(arr));

    }
}

/*
{1,2,1,3,2,1,2,1}

1 to 2

2 to 1 or 3

1 to 3

3 to 2 or 2 or 1
 */
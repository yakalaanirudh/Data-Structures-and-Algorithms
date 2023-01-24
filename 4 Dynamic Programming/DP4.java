//Longest increasing sub sequence

class LongestIncreasingSubsequence{
    public int lsLength(int[] arr){
        int[] ans=new int[arr.length];  //Create a new array

        for(int i=0;i<ans.length;i++){  //Populate each index of that array with value 1
            ans[i]=1;
        }

        int maxlength=1;            //Initially max length=1


        /*
        For each index i
        In inner loop
            For each index j taht is less than i
            If that index value is less than(arr[j]<arr[i]) and 1 increment + current value >current value
            then update value by 1
            Max length is max of(max length and last index value
         */
        for(int i=1;i<ans.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && 1+ans[j]>ans[i]){
                    ans[i]=ans[i]+1;
                    maxlength=Math.max(maxlength,ans[i]);
                }
            }
        }
        return maxlength;
    }
}

public class DP4{
    public static void main(String[] args){

        LongestIncreasingSubsequence a=new LongestIncreasingSubsequence();

        int[] arr={7,1,4,8,11,2,14,3};

        System.out.println(a.lsLength(arr));
    }
}

/*
7,1,4,8,11,2,14,3

there are many increasing sub sequence
7,8,11,14
1,4,8,11,14

But 1,4,8,11,14 is longest
 */

/*
[7,1,4,8,11,2,14,3]


[1,1,1,1,1,1,1,1]
[1,1,2,1,1,1,1,1]       4>1 so increment 1+1=2
[1,1,2,3,1,1,1,1]
    8>7 so increment by 1 (1+1=2)
    8>1 but we can increment by 1 1+1=2 which is current value and it is not greater so do not increment
    8>4 acurrently we have value 2 2+1=3>2 so proceed
 */
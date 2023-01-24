//Longest increasing sub sequence

class MaxSumIncSubsequence{
    public int lsLength(int[] arr){
        int[] ans=new int[arr.length];      //Create a new array

        for(int i=0;i<ans.length;i++){      //Populate each index of that array with value of its value
            ans[i]=arr[i];
        }

        int maxSum=1;

        for(int i=1;i<ans.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && 1+ans[j]>ans[i]){
                    ans[i]=ans[i]+ans[j];
                    maxSum=Math.max(maxSum,ans[i]);
                }
            }
        }
        return maxSum;
    }
}

public class DP5{
    public static void main(String[] args){

        MaxSumIncSubsequence a=new MaxSumIncSubsequence();

        int[] arr={7,1,4,8,11,2,14,3};

        System.out.println(a.lsLength(arr));
    }
}
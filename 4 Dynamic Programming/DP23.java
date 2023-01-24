//Maximum Sum if consecutive elements not allowed

class maxSum{
    public int maxsumalt(int[] arr){
        if(arr.length==0){
            return 0;
        }

        if(arr.length==1){
            return arr[0];
        }

        int[] dp=new int[arr.length];
        dp[0]=arr[0];
        dp[1]=arr[0]>arr[1]?arr[0]:arr[1];

        for(int i=2;i<arr.length;i++){
            dp[i]=Math.max(dp[i-1],arr[i]+dp[i-2]);
        }
        return dp[arr.length-1];
    }
}

public class DP23{
    public static void main(String[] args){
        maxSum a= new maxSum();

        int[] arr={4,2,3,5,1,6,7};

        System.out.println(a.maxsumalt(arr));
    }
}
/*
{4,2,3,5,1,6,7}     4   5   7

if only one index we select that index so we select 4
if two indexes we select the greater index so we select 4


from index =2
we select such that the sum at that index is max of(a,b)
where
a=the value at earlier index(it means we exclude this index)
b=sum of this index and total sum till index-2

 */
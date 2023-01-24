//Minimum jumps to reach a nth floor

class minStair{
    public int mintotalWaysNthStairRecursion(int n){
        if(n==0){return 0;}
        if(n==1 || n==2 ||n==3){return 1;}

        return Math.min(mintotalWaysNthStairRecursion(n-1),Math.min(mintotalWaysNthStairRecursion(n-2),mintotalWaysNthStairRecursion(n-2)));
    }

    public int mintotalWaysNthStairTopDown(int[] arr,int n){
        if(n==0){return 0;}
        if(n==1 || n==2 ||n==3){return 1;}

        if(arr[n]==0){
            arr[n]=1+Math.min(mintotalWaysNthStairTopDown(arr,n-1),Math.min(mintotalWaysNthStairTopDown(arr,n-2),mintotalWaysNthStairTopDown(arr,n-2)));
        }

        return arr[n];
    }

    public int mintotalWaysNthStairDownTop(int n){
        int a=1;
        int b=1;
        int c=1;
        int d;

        for(int i=3;i<=n;i++){
            d=1+Math.min(Math.min(a,b),c);

            a=b;
            b=c;
            c=d;
        }
        return c;
    }

}


public class DP3{
    public static void main(String[] args){
        minStair a=new minStair();

        int n=4;

        System.out.println(a.mintotalWaysNthStairRecursion(n));

        int[] arr=new int[n+1];

        System.out.println(a.mintotalWaysNthStairTopDown(arr,n));

        System.out.println(a.mintotalWaysNthStairDownTop(n));

    }
}

/*
The minimum steps to reach ground floor is 0 as we are on ground floor

The minimum steps to reach 1st,2nd ,3rd floors is 1 as we can step[1,2,3]

The minimum number of ways to reach nth floor is minimum number of ways to reach [n-1,n-2,n-3]+1
The plus is to reach from that floor to nth floor
 */
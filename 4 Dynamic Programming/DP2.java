//Total number of ways to reach nth floor

class Stair{
    public int totalWaysNthStairRecursion(int n){
        if(n==0){return 1;}
        if(n==1){return 1;}
        if(n==2){return 2;}

        return totalWaysNthStairRecursion(n-1)+totalWaysNthStairRecursion(n-2)+totalWaysNthStairRecursion(n-2);
    }

    public int totalWaysNthStairTopDown(int[] arr,int n){
        if(n==0){return 1;}
        if(n==1){return 1;}
        if(n==2){return 2;}

        if(arr[n]==0){
            arr[n]=totalWaysNthStairTopDown(arr,n-1)+
                    totalWaysNthStairTopDown(arr,n-2)+
                    totalWaysNthStairTopDown(arr,n-3);
        }

        return arr[n];
    }

    public int totalWaysNthStairDownTop(int n){
        int a=1;
        int b=1;
        int c=2;
        int d;

        for(int i=3;i<=n;i++){
            d=a+b+c;

            a=b;
            b=c;
            c=d;
        }
        return c;
    }

}


public class DP2{
    public static void main(String[] args){
        Stair a=new Stair();

        int n=4;

        System.out.println(a.totalWaysNthStairRecursion(n));

        int[] arr=new int[n+1];

        System.out.println(a.totalWaysNthStairTopDown(arr,n));

        System.out.println(a.totalWaysNthStairDownTop(n));
    }
}

/*
//In recursion time complexity is O(3^n) because we can jump three ways (1,2,3)
We can do jumps in three ways 1 jump 2 jump 3 jump

ground floor 1 way only no jump

1st floor   1 way       only 1 jump

2nd floor   2 ways      [(2,0),(1,1)]

3rd floor   4 ways      [(1,1,1),(2,1),(1,2),(3,0)]


So what we do is the number of ways to reach floor is equal to sum of all ways to reach earlier 3 floors

4th floor   =1st floor+2nd floor+3rd floor  [1,2,4]    7 ways

So what we do is the number of ways to reach floor is equal to sum of all ways to reach earlier 3 floors

5th floor   =2nd floor+3rd floor+4th floor  [2,4,7]    13 ways
 */
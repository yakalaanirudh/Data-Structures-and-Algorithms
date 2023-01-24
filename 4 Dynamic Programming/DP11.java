//Bounded Knapsack Problem

class Knapsack{
    public int getMaxProfit(int[] wt,int[] pr,int capacity){
        if(wt.length==0 || pr.length==0 ||capacity<=0){
            return 0;
        }

        int[][] arr=new int[wt.length][capacity+1];

        for(int i=0;i<=capacity;i++){
            if(wt[0]<=i){
                arr[0][i]=pr[0];
            }
        }

        for(int i=0;i<=wt.length;i++){
            for(int j=0;j<=capacity;j++){

                int includingProfit=0;
                if(wt[i]<=j){
                    includingProfit=pr[i]+arr[i-1][j-wt[i]];
                }

                arr[i][j]=Math.max(includingProfit,arr[i-1][j]);
            }
        }

        return arr[wt.length-1][capacity];
    }
}

public class DP11{

    public static void main(String[] args) {
        Knapsack a = new Knapsack();
        int[] wt = {1, 2, 3, 5};
        int[] pr = {1, 4, 7, 10};

        int capacity = 8;

        System.out.println(a.getMaxProfit(wt, pr, capacity));

    }
}
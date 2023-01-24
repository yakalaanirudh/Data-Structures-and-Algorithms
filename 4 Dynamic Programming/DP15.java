//Unbounded Knapsack Problem
//We can take an item n number of times
class Knapsack2{
    public int getMaxProfit(int[] wt,int[] pr,int totalCapacity){
        if(wt.length==0 || pr.length==0 ||totalCapacity<=0){
            return 0;
        }

        int numberOfWeights=wt.length;
        int[][] arr=new int[wt.length][totalCapacity+1];


        for(int i=0;i<=numberOfWeights;i++){
            for(int j=0;j<=totalCapacity;j++){

                int includingProfit=0;
                int excludingProfit=0;

                if(wt[i]<=j){
                    includingProfit=pr[i]+arr[i-1][j-wt[i]];
                }

                if(i>0){
                    excludingProfit=arr[i-1][j];
                }

                arr[i][j]=Math.max(includingProfit,excludingProfit);
            }
        }

        return arr[numberOfWeights-1][totalCapacity];
    }
}

public class DP15{

    public static void main(String[] args) {
        Knapsack2 a = new Knapsack2();
        int[] wt = {1, 2, 3, 5};
        int[] pr = {1, 4, 7, 10};

        int totalCapacity = 8;

        System.out.println(a.getMaxProfit(wt, pr, totalCapacity));

    }
}

/*
                if(i>0){
                    excludingProfit=arr[i-1][j];
                }

The above syntax means if the iterator is at i we are excluding the earlier item so[i-1] (the row above)
 */
//Bounded Knapsack Problem
//One item only once
class Knapsack{
    public int getMaxProfit(int[] wt,int[] pr,int capacity){
        if(wt.length==0 || pr.length==0 ||capacity<=0){
            return 0;
        }

        int[][] arr=new int[wt.length][capacity+1];     //Initially all the entries in the matrix are 0

        /*
        Then for the first row as soon as the capacity reaches first entry weight and till the end
        The profit is equal to profit of the first item
         */
        for(int i=0;i<=capacity;i++){
            if(wt[0]<=i){
                arr[0][i]=pr[0];
            }
        }


        /*
        Now we go to the second row

        Till the weight reaches the weight required to store 2nd item completely we fill only 1st item(the row above)
                        arr[i][j]=Math.max(includingProfit,arr[i-1][j]);
        arr[i-1][j] is above row

        If the current item is included then it is profit of current(pr[i]) plus
        the item that can be stored in weight taht is the difference between (capacity and weight of current)
        That value is available in arr[i-1][j-wt[i]]
        The previous item (arr[i-1])
        [j-wt[i]]   j is current capacity and wt[i] is current item weight
        ([j-wt[i]]) give sthe difference weight
                        if(wt[i]<=j){
                            includingProfit=pr[i]+arr[i-1][j-wt[i]];
                        }
         */
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

/*
The matrix is constructed sounch that
The row 0 means only 1st item considered
The row 1 means (1st,2nd) item considered
The row 2 means (1st,2nd,3rd) item considered
The row 3 means (1st,2nd,3rd,4th) item considered

The columns are created such that
0th column total capacity is 0
1st column total capacity is 1
2nd column total capacity is 2
3rd column total capacity is 3


 */
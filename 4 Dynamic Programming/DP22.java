//Max Pices retrieved after cutting piece of given length
//This is like Knapsack Unbounded
class Knapsack2{
    public int getMaxProfit(int[] pieces,int piecelength){
        if(pieces.length==0 || piecelength<=0){
            return 0;
        }

        int numberofPieces=pieces.length;
        int[][] dp=new int[numberofPieces][piecelength+1];

        for(int i=0;i<=numberofPieces;i++) {
            for (int j = 0; j <= piecelength; j++) {
                dp[i][j]=-1;

            }
        }

        for(int i=0;i<=numberofPieces;i++) {
            dp[i][0]=0;
        }

        for(int i=0;i<=numberofPieces;i++){
            for(int j=0;j<=piecelength;j++){

                int includingCurrentPiece=-1;
                int excludingCurrentPiece=-1;

                if(pieces[i]<=j &&dp[i][j-pieces[i]]!=-1){
                    includingCurrentPiece=1+dp[i][j-pieces[i]];
                }

                if(i>0){
                    excludingCurrentPiece=dp[i-1][j];
                }

                dp[i][j]=Math.max(includingCurrentPiece,excludingCurrentPiece);
            }
        }

        return dp[numberofPieces-1][piecelength];
    }
}

public class DP22{

    public static void main(String[] args) {
        Knapsack2 a = new Knapsack2();
        int[] pieces = {4, 2, 3, 5};

        int piecelength = 7;

        System.out.println(a.getMaxProfit(pieces, piecelength));

    }
}
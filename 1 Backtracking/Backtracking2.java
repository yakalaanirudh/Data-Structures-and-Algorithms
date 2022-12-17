//N Queen Problem
//We fill the solution matrix column wise


class NQueenProblem{
    final int N;

    NQueenProblem(int N){
        this.N=N;
    }

    public boolean queenProblem(){
        int[][] sol=new int[N][N];

        if(!queenProblemUtil(0,sol)){
            System.out.println("N-Queen Placement not possible");
            return false;
        }

        printQueenPlacement(sol);
        return true;
    }

    private boolean queenProblemUtil(int col,int[][] sol){

        if(col>=N){             //This means we are trying to place queen in N+1 column so we place din N successfully so return true
            return true;
        }

        for(int i=0;i<N;i++){           //Here we are iterating row i is row index

            if(isSafeToPlaceQueen(i,col,sol)){
                sol[i][col]=1;

                if(queenProblemUtil(col+1,sol)){
                    System.out.println(i+" "+col);
                    return true;
                }

                sol[i][col]=0;      //Backtrack set back value to 0
            }
        }

        return false;
    }


    private boolean isSafeToPlaceQueen(int row,int col,int[][] sol){
        int i,j;

        for(i=0;i<col;i++){
            if(sol[row][i]==1){         //Row-wise checking
                return false;
            }
        }

        for(i=row,j=col;i>=0 && j>=0;i--,j--){      //Left up checking
            if(sol[i][j]==1){
                return false;
            }
        }

        for(i=row,j=col;i<N && j>=0;i++,j--){       //Left down checking
            if(sol[i][j]==1){
                return false;
            }
        }

        return true;
    }


    private void printQueenPlacement(int[][] mat){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.println(mat[i][j]+" ");
            }

            System.out.println();
        }
    }
}


public class Backtracking2{
    public static void main(String[] args){

        int m=4;
        NQueenProblem n=new NQueenProblem(m);


        n.queenProblem();

    }
}

//We fill the solution matrix column wise
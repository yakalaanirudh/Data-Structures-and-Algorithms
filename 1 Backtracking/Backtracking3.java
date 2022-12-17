//Sudoku Problem

class Sudoku{

    public static boolean sudokuAutomation(int[][] board,int n){
        int row=-1;
        int col=-1;

        boolean isEmpty=true;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                    row=i;
                    row=j;

                    isEmpty=false;
                    break;      //break from inner for loop when a 0 is found
                }
            }

            if(!isEmpty){       //when broken out of inner for loop break out of outer for loop too
                break;
            }
        }

        if(isEmpty){
            return true;        //When all filled is empty returns false so we return true to render
        }

        for(int num=1;num<=n;num++){
            if(isSafePlace(board,row,col,num)){     //We are apssing the first encountered 0s row and col indices
                board[row][col]=num;
                if(sudokuAutomation(board,n)){      //Recursive call for next 0
                    return true;
                }else{
                    board[row][col]=0;      //Backtrack put back 0
                }
            }
        }

        return false;                       //Here we return false because no number can be placed after all itertaions of for loop
    }

    public static boolean isSafePlace(int[][] board,int row,int col,int num) {
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == num) {     //row check
                return false;
            }
        }


        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {     //column check
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(board.length);       //box check
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int d = colStart; d < colStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printSudokuBoard(int[][] board,int N){
        for(int row=0;row<N;row++){
            for(int col=0;col<N;col++){
                System.out.print(board[row][col]);
                System.out.println(" ");
            }
            System.out.println();
        }
    }


}

public class Backtracking3{
    public static void main(String[] args){
        Sudoku s=new Sudoku();

        int[][] board=new int[][]   {
                                    {0,2,3,0},
                                    {0,0,0,1},
                                    {0,1,0,0},
                                    {2,4,1,0},
                                    };

        int N=board.length;

        if(s.sudokuAutomation(board,N)){
            s.printSudokuBoard(board,N);
        }else{
            System.out.println("No Solution Exists");
        }
    }
}
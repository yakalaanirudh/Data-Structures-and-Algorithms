//Rate Maze problem
//The rat can only go through indices with 1
//Time complexityO(n^2)

class RatMaze{
    final int N=4;

    public boolean printMazePath(int[][] maze){
        int[][] sol=new int[N][N];          //This is the solution path matrix

        if(!printMazePathUtil(maze,0,0,sol)){       //If it returns false return false
            System.out.println("Rat Cant reach the end");
            return false;
        }

        printPath(sol);             //else print the solution matrix and return true
        return true;
    }

    private boolean printMazePathUtil(int[][] maze,int x,int y,int[][] sol){

        if(x==N-1 && y==N-1 &&maze[x][y]==1){       //Last right bottom can be 0 then no solution so maze[x][y]==1 we check
            sol[x][y]=1;
            return true;
        }

        if(isSafe(maze,x,y)){                   //If 1 then in solution set 1
            sol[x][y]=1;

            if(printMazePathUtil(maze,x+1,y,sol)){      //down-side first next row      recursively calling parent function
                return true;
            }

            if(printMazePathUtil(maze,x,y+1,sol)){      //right-side first next column  recursively calling parent function
                return true;
            }

            sol[x][y]=0;                //Here we backtrack if next row or column 0 we go back
        }

        return false;
    }

    //It returns true if the element is between matrix borders and element is equal to 1
    private boolean isSafe(int[][] maze,int x,int y){
        if(x>=0 && x<N && y>=0 &&y<N && maze[x][y]==1){
            return true;
        }

        return false;
    }

    private void printPath(int[][] mat){        //This prints the matrix
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.println(mat[i][j]+" ");
            }

            System.out.println();
        }
    }
}


public class Backtracking1{
    public static void main(String[] args){
        RatMaze rat=new RatMaze();

        int maze[][]=   {
                        {1,0,0,0},
                        {1,1,1,0},
                        {1,0,1,1},
                        {1,0,0,1}
                        };

        rat.printMazePath(maze);

    }
}

/*
We use dfs for this
For this example lets assume
the rat prefers to go down first and then right

We create a path matrix

 */
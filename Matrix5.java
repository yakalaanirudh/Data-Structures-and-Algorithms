//Rotten Oranges
import java.lang.*;
import java.util.*;

class RottenOranges{

    private int[][] directions={{-1,0},{0,-1},{1,0},{0,1}};     //Directions for BFS

    public int orangesRotting(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;

        int freshOranges=0;     //Firsts et fresh oranges to 0


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ++freshOranges;         //Add fresh oranges whenever we get 1
                }
            }
        }

        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(1*n+j);       //Add rotten oranges to queue whenever we get 2
                }
            }
        }

        int minutes=0;
        while(!queue.isEmpty() && freshOranges>0){      //this queue will pop till one cycle is complete it wont pop continuously
            int size=queue.size();
            for (int i = 0; i < m; i++) {
                int num=queue.poll();
                int row=num/n;
                int col=num%n;

                for(int[] direction:directions){        //Here for 1 iteration 1 orange in all 4 directions gets rotted
                    int x=direction[0]+row;
                    int y=direction[1]+col;

                    if(x>-1 && y>-1 && x<m && y<n && grid[x][y]==1){        //If within borders and fresh
                        queue.add(x*n+y);                                   //Add element to queue
                        freshOranges--;                                     //Decrease fresh count
                        grid[x][y]=2;                                       //Make fresh rotten
                    }
                }
            }
            ++minutes;          //After one cycle of popping increment minutes
        }

        return minutes;
    }
}

public class Matrix5{
    public static void main(String[] args){
        RottenOranges a=new RottenOranges();

        int[][] x={{'1','2','1','1'},{'1','1','0','0'},{'1','1','1','0'},{'2','0','1','1'}};
        a.orangesRotting(x);
    }
}

/*
Converting coordinates to integers

1   2   3
4   5   6
7   8   9
 */
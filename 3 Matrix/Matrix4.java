//Number of islands
import java.lang.*;
import java.util.*;

class NumberOfIslands{

    public int Number(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == '1') {        //Increase island count when we first a 1
                    ++islandCount;

                    //call a helper method to do a dfs from that element indices
                    changeLandTowater(grid, i, j);    //Changing 1 at that index to 0
                }
            }
        }

        return islandCount;
    }

        private void changeLandTowater(char[][] grid,int i,int j){
            if(i<0 ||i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0') {return;}

            grid[i][j]='0';                             //First make that element
            changeLandTowater(grid,i-1,j);              //Make top element 0
            changeLandTowater(grid,i+1,j);              //Make bottom element 0
            changeLandTowater(grid,i,j-1);              //Make left element 0
            changeLandTowater(grid,i,j+1);              //Make right element 0
        }
}


public class Matrix4{
    public static void main(String[] args){
        NumberOfIslands a=new NumberOfIslands();

        char[][] x={{'1','0','0','0'},{'1','1','0','0'},{'1','0','1','0'},{'1','0','1','1'}};
        a.Number(x);
    }
}
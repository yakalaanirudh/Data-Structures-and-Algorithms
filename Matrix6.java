//Perimetre of Island
class Perimetre{
    public int islandPerimeter(int[][] grid){
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }

        int result=0;

        int rownum=grid.length;
        int colnum=grid[0].length;

        for(int i=0;i<rownum;i++){
            for(int j=0;j<colnum;j++){
                if(grid[i][j]==1){
                    result=result+4;                //For every 1 in matrix increase perimetre by 4

                    if(i>0 && grid[i-1][j]==1){     //If a 1 above row in matrix reduce by 2
                        result=result-2;
                    }

                    if(i>0 && grid[i][j-1]==1){     //If a 1 left column in matrix reduce by 2
                        result=result-2;
                    }
                }
            }
        }

        return result;
    }
}

public class Matrix6{
    public static void main(String[] args){
        Perimetre p= new Perimetre();

        int[][] a=  {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        System.out.println(p.islandPerimeter(a));
    }
}
//Max Gold Path

class MaxGold{
    public int getMaximumGold(int[][] grid){
        if(grid==null || grid.length==0){return 0;}

        int max=0;
        int m=grid.length;
        int n=grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]>0){
                    int gold=findMaxGold(grid,i,j,m,n,new boolean[m][n]);   //Do helper at first non zero found
                    max=Math.max(max,gold);
                }
            }
        }
        return max;
    }

    private int findMaxGold(int [][] grid,int i,int j,int m,int n,boolean[][] visited){     //Implements DFS
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j]) {return 0;}

        visited[i][j]=true;                     //Mark that index true

        int left=findMaxGold(grid,i,j-1,m,n,visited);       //DFS of left
        int right=findMaxGold(grid,i,j-1,m,n,visited);      //DFS of right
        int top=findMaxGold(grid,i,j-1,m,n,visited);        //DFS of top
        int down=findMaxGold(grid,i,j-1,m,n,visited);       //DFS of down
        visited[i][j]=false;                    //Backtrack to set not visited

        return Math.max(left,Math.max(right,Math.max(top,down)))+grid[i][j];



    }
}

public class Matrix7{
    public static void main(String[] args){
        MaxGold a=new MaxGold();

        int [][] x={{10,7,0},{11,5,0},{0,0,5}};
        System.out.println(a.getMaximumGold(x));
    }
}
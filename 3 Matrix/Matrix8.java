//Largest island area

class MaxArea{
    public int maxAreaUtil(int[][] grid){
        if(grid==null || grid.length==0){return 0;}

        int max=0;
        int m=grid.length;
        int n=grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    int area=getArea(grid,i,j,n,m);   //Do helper at first non zero found
                    max=Math.max(max,area);
                }
            }
        }
        return max;
    }

    private int getArea(int [][] grid,int i,int j,int n,int m){     //Implements DFS
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0) {return 0;}

        grid[i][j]=0;                     //Mark that index 0

        int left=getArea(grid,i,j-1,n,m);       //DFS of left
        int right=getArea(grid,i,j-1,n,m);      //DFS of right
        int top=getArea(grid,i,j-1,n,m);        //DFS of top
        int down=getArea(grid,i,j-1,n,m);       //DFS of down

        return left+right+top+down+1;

    }
}


public class Matrix8{
    public static void main(String[] args){
        MaxArea a=new MaxArea();

        int [][] x={{1,1,1,0},{0,0,0,1},{1,1,1,1},{1,0,1,1}};
        System.out.println(a.maxAreaUtil(x));
    }
}
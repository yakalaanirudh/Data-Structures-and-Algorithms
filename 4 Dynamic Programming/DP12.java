//Check is a sub array exists which forms required sum

class subsetSum{
    public boolean ifexists(int[] arr,int sum){
        if(arr.length==0){
            return false;
        }

        boolean[][] mat=new boolean[arr.length][sum+1];

        //0 can be achieved as sum with every element so we make first column 0
        for(int i=0;i<=arr.length;i++){
            mat[i][0]=true;
        }

        //In the first row we make the column when index is equal to arr[0] true
        for(int j=0;j<=arr.length;j++){
            if(j==arr[0]) {
                mat[0][j] = true;
            }
        }

        /*
        From second row
        If the value at above row in same column is true it is marked true
        else
        if the column(sum till then) is greater than that array index value
        we mark that row column index as the value in above row and index of sum till then and that array index value
         */
        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=arr.length;j++){

                if(mat[i-1][j]){
                    mat[i][j]=true;
                }else{
                    if(j>=arr[i]){
                        mat[i][j]=mat[i-1][j-arr[i]];
                    }
                }
            }
        }

        return mat[arr.length-1][sum];
    }
}

public class DP12{
    public static void main(String[] args){
        subsetSum a=new subsetSum();

        int[] arr={1,2,3,5};
        int sum=7;

        System.out.println(a.ifexists(arr,sum));
    }
}

/*

 */


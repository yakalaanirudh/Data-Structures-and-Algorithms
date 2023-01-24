//Check if equal sum partition exists

class subsetHalf{
    public boolean ifhalved(int[] arr){
        if(arr.length==0){
            return false;
        }

        int sumofArray=0;
        for(int i=0;i<=arr.length;i++){
            sumofArray=sumofArray+arr[i];
        }

        if(sumofArray%2!=0){
            return false;
        }

        int sum=sumofArray/2;

        boolean[][] mat=new boolean[arr.length][sum+1];

        for(int i=0;i<=arr.length;i++){
            mat[i][0]=true;
        }

        for(int j=0;j<=arr.length;j++){
            if(j==arr[0]) {
                mat[0][j] = true;
            }
        }

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

public class DP13{
    public static void main(String[] args){
        subsetHalf a=new subsetHalf();

        int[] arr={1,2,3,5};
        //int sum=7;

        System.out.println(a.ifhalved(arr));
    }
}

/*
The sum of elements is found
If its half is even then we find if that sum can be achieved using DP12
if the sum of elements is odd we return false
 */
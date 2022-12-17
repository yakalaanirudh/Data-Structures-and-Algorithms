//To find number of elements greater than given number
//This method time complexity is O(m+n)

public class Matrix3{

    public static int numberOfElementsGreaterThanGivenValue(int[][] mat,int val){
        if(mat.length==0){
            System.out.println("Matrix is Blank");
            return -1;
        }

        int totalRows=mat.length;
        int totalColumns=mat[0].length;

        int row,column;
        row=0;
        column=totalColumns-1;

        int count=0;

        while(row<totalRows&&column>=0){
            if(val<=mat[row][column]){
                count=count+totalRows-row;
                column--;
            }
            else{
                row++;
            }
        }

        return count;
    }

    public static void main(String[] args){
        int[][] mat = {{2, 7, 15},{4,9,19},{6,10,24}};

        System.out.println(numberOfElementsGreaterThanGivenValue(mat,6));
    }
}
//We find if an element is present in a sorted matrix or not
//This method time complexity is O(m+n)
public class Matrix1{

    public static void searchElementInRowColumnSortedMatrix(int[][] mat,int val){
        if(mat.length==0){
            System.out.println("Matrix is Blank");
            return;
        }

        int totalRows=mat.length;
        int totalColumns=mat[0].length;

        int row,column;
        row=0;
        column=totalColumns-1;

        while(row<totalRows &&column>=0){
            if(mat[row][column]==val){
                System.out.println("Value is present at:"+row+" "+column);
                break;
            }
            if(val>mat[row][column]){
                row++;
            }
            else{
                column--;
            }
        }

        System.out.println("Value is not present in the matrix");
    }

    public static void main(String[] args) {
        int[][] mat = {{2, 7, 15},{4,9,19},{6,10,24}};

        searchElementInRowColumnSortedMatrix(mat,10);
    }
}

/*
We will start at last element of top row
the elements to its left are smaller,down are larger
if element less we go left if great we go down till we find element
 */
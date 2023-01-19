//Print elements that are greater all its succeeding elements
//[14,15,8,9,5,2]       [15,9,5,2]
class ArrayProblems14{
    public void printElementsGreaterEqualToRightSide(int[] arr){
        int max=Integer.MIN_VALUE;

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>max){
                max=arr[i];
                System.out.println(arr[i]+" ");
            }

        }
    }
}


public class Array14{
    public static void main(String[] args){
        ArrayProblems14 a=new ArrayProblems14();

        int arr[]={14,15,8,9,5,2};
        a.printElementsGreaterEqualToRightSide(arr);
    }
}
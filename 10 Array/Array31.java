//Shuffle an array

import java.util.Random;

class ArrayProblems31{
    public void shuffleNumbers(int[] arr){

        Random randomObject=new Random();           //Random Object

        for(int i=0;i<arr.length;i++){
            int randomValue=randomObject.nextInt(arr.length);   //This generates number between 0 and (arr.length-1)

            int currentValue=arr[i];        //We save the current index value in a variable(M)
            arr[i]=arr[randomValue];        //We assign the value at randomIndex to current index
            arr[randomValue]=currentValue;  //We swap variable ms value with randomIndex value
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
        System.out.println();
    }
}
public class Array31{
    public static void main(String[] args) {
        ArrayProblems31 a = new ArrayProblems31();

        int arr[] = {3, 7, 4, 1, 8, 9, 10};

        a.shuffleNumbers(arr);
    }
}

//This is insertion sort
//Time Complexity is O(n^2)

class ArrayApp{
    public static void insertSort(int[] arr){
        if(arr.length<=1){
            return;
        }
        /*
        [7,3]
         */
        for(int i=1;i<arr.length;i++){
            int key=arr[i];                                //key=3
            int j;

            //Iterate till we reach the starting index of the array
            //Get teh before index
            //If it is greater than arr[i]  then swap
            for(j=i-1;j>=0 && arr[j]>key;j--){
                arr[j+1]=arr[j];
            }

            arr[j+1]=key;                               //Reassignment outside for loop
        }
    }
}

public class Array6{
    public static void main(String[] args){
        int a[]={5,14,2,3,1};

        System.out.println("Input: ");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }

        ArrayApp.insertSort(a);

        System.out.println();

        System.out.println("Output: ");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }
    }
}

/*
12  11  13  5   6

[12  11]  13  5   6

[11  12]  13  5   6

11  [12  13]  5   6

11  12  [13  5]   6

11  12  [5  13]   6

11  [5   12]  13   6

[5   11]  12  13   6

5   11  12  [13 6]

5   11  12  [6  13]

5   11  [6  12] 13

5   [6  11]  12 13

5   6   11  12  13
 */
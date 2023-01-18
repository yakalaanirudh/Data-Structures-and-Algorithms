//QuickSort
//Time Compexity O(nlogn)

class ArrayApp{

    public static void QuickSort(int[] arr,int start,int end){
        int pivot,i,j,temp;

        if(start<end){
            pivot=start;
            i=start;
            j=end;

            while(i<j){
                while(arr[i]<=arr[pivot] && i<end){i++;}
                while(arr[j]>arr[pivot] && i>=0){j--;}

                if(i<j){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }

            temp=arr[pivot];
            arr[pivot]=arr[j];
            arr[j]=temp;

            QuickSort(arr,start,j-1);
            QuickSort(arr,j+1,end);
        }
    }
}


public class Array9{
    public static void main(String[] args){
        int a[]={5,14,2,3,1};

        System.out.println("Input: ");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }

        ArrayApp.QuickSort(a,0,a.length-1);

        System.out.println();

        System.out.println("Output: ");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }
    }
}
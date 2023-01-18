//MergeSort
//Time Complexity is O(nlogn)


class ArrayApp{
    public static void MergeSort(int arr[],int begin,int end){
        if(begin!=end){
            int mid=(begin+end)/2;
            MergeSort(arr,begin,mid);
            MergeSort(arr,mid+1,end);
            Merge(arr,begin,mid,end);
        }
    }

    private static void Merge(int[] arr,int start,int mid,int end){
        int i=start;
        int j=mid+1;
        int k=0;

        int[] temp=new int[end-start+1];

        while((i<=mid) &&(j<=end)){
            if(arr[i]<arr[j]) {
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=end){
            temp[k++]=arr[j++];
        }

        for(i=start;i<=end;i++){
            arr[i]=temp[i-start];
        }
    }
}


public class Array8{
    public static void main(String[] args){
        int a[]={5,14,2,3,1};

        System.out.println("Input: ");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }

        ArrayApp.MergeSort(a,0,a.length-1);

        System.out.println();

        System.out.println("Output: ");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }
    }
}
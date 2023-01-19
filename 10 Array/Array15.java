//Search for a value in sorted and unsorted array
class ArrayProblems15{
    public int searchValueInUnsortedArray(int[] arr,int val){
        if(arr.length==0){
            return -1;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]==val){
                return i;
            }
        }

        return -1;
    }

    public int searchValueInSortedArray(int[] arr,int val,int start,int end){
        if(arr.length==0){
            return -1;
        }

        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==val){
                return mid;
            }else if(val>arr[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        return -1;
    }
}


public class Array15{
    public static void main(String[] args){
        ArrayProblems15 a=new ArrayProblems15();

        int arr1[]={5,90,3,6,1};
        int index1=a.searchValueInUnsortedArray(arr1,3);
        System.out.println(index1);

        int arr2[]={1,3,7,10,45};
        int index2=a.searchValueInSortedArray(arr2,3,0,arr2.length-1);
        System.out.println(index2);
    }
}
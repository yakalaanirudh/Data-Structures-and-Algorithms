//Searching for an element in an array
//This is Binary Search approach
//Its time complexity is O(log n)
//This works on a sorted array only

class BinarySearchingAnElement{

    public int searchIndex(int a[],int val,int start,int end){
        if(a.length==0 || start>end){
            return -1;
        }

        int mid=(start+end)/2;

        if(val==a[mid]){
            return mid;
        }

        if(val<a[mid]){
            return searchIndex(a,val,start,mid-1);
        }else{
            return searchIndex(a,val,mid+1,end);
        }

    }
}


public class Array4{
    public static void main(String[] args){

        BinarySearchingAnElement obj=new BinarySearchingAnElement();
        int a[] ={12,34,45,6,13};
        int i=obj.searchIndex(a,34,0,a.length-1);

        if(i==-1){
            System.out.println("Value doesn't exists in array");
        }else{
            System.out.println(i);
        }
    }

}
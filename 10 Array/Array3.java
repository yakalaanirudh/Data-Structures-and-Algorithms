//Searching for an element in an array
//This is brute force approach
//Its time complexity is O(n)

class SearchingAnElement{

    public int searchIndex(int a[],int val){
        if(a.length==0){
            return -1;
        }

        for(int i=0;i<a.length;i++){
            if(a[i]==val){
                return i;
            }
        }

        return -1;
    }
}


public class Array3{
    public static void main(String[] args){

        SearchingAnElement obj=new SearchingAnElement();
        int a[] ={12,34,45,6,13};
        int i=obj.searchIndex(a,34);

        if(i==-1){
            System.out.println("Value doesn't exists in array");
        }else{
            System.out.println(i);
        }
    }

}
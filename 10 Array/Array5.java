//This is sorting an array using bubble sort
//In bubble sort the largest element goes out of the bubble
//Time complexity is O(n^2)


public class BubbleSort{

    public void bubbleSort(int a[]){
        if(a.length==0 || a.length==1){
            return;
        }

        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int x=a[j];
                    a[j]=a[j+1];
                    a[j+1]=x;
                }
            }
        }
    }

    public void print(int a[]){
        for(int i=0;i<a.length+i++){
            System.out.println(a[i]+" ");
        }
        System.out.println();
    }
}

public class Array5{
    public static void main(String [] args){

        int a[]={12,5,3,-1};
        BubbleSort obj=new BubbleSort();
        obj.print(a);
        obj.bubbleSort(a);
        obj.print(a);
    }
}

/*
12  5   3   -1
5   12  3   -1
5   3   12  -1
5   3   -1  (12)

3   5   -1  (12)
3   -1  (5   12)


-1  (3   5   12)

//a.length-1-i
-i because for every one iteration one number is bubbled out
0th iteration 0 bubbled out
1st iteration 1 bubbled out
2nd iteration 2 bubbled out
3rd iteration 3 bubbled out


 */

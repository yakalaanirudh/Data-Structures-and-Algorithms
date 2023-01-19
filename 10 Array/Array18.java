//Find 1st occurence of a value if adjacent value atmost differs by k

class ArrayProblems18{
    public int findFirstOccurenceIfAdjacentValueDifferByk(int[] arr,int k,int val){
        if(arr.length==0){
            return -1;
        }

        int start=0;

        while(start<arr.length){
            if(arr[start]==val){
                return start;
            }

            int diff=Math.abs(arr[start]-val)/k;
            diff=Math.max(1,diff);
            start=start+diff;
        }

        return -1;
    }


}

public class Array18{
    public static void main(String[] args){
        ArrayProblems18 a=new ArrayProblems18();

        int arr[]={70,60,70,80,90,110,130};

        System.out.println(a.findFirstOccurenceIfAdjacentValueDifferByk(arr,20,110));
    }
}

/*
[70,60,70,80,90,110,130]    diff=20  target=110

((70-110)/20)=40/20=2
Max(1,2)    =2

70,60,70
((70-110)/20)=40/20=2
Max(1,2)    =2

70,80,90
((90-110)/20)=20/20=1
Max(1,2)    =1

110
 */

/*
[2,3,2,4,5,6,7]    diff=1  target=6

((2-6)/20)=4/1=4
Max(1,4)    =4

2,3,2,4,5
((5-6)/1)=1/1=1
Max(1,1)    =1

5,6

 */
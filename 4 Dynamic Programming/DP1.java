//Get Fibonacci Number

class DPFib{

    public int getFibNumberRecursion(int n){
        if(n<2){
            return n;
        }

        return getFibNumberRecursion(n-1)+getFibNumberRecursion(n-2);
    }

    public int getFibNumberTopDown(int[] arr,int n){
        if(n<2){
            return n;
        }

        if(arr[n]==0){
            arr[n]=getFibNumberTopDown(arr,n-1)+getFibNumberTopDown(arr,n-2);
        }

        return arr[n];
    }

    public int getFibNumberDownTop(int n){
        int a=0;
        int b=1;
        int c;

        for(int i=2;i<=n;i++){
            c=a+b;

            a=b;
            b=c;
        }

        return b;
    }
}

public class DP1{
    public static void main(String[] args){
        DPFib a=new DPFib();

        int n=10;
        System.out.println(a.getFibNumberRecursion(n));

        int[]arr=new int[n+1];
        System.out.println(a.getFibNumberTopDown(arr,n));
        System.out.println(a.getFibNumberDownTop(n));
    }
}

/*
In recursion we call the function evrytime so its time complexity is O(2^n)

In TopDown we save the value calculated till that index in an array
and call that array when we need to calculate that value again


In DownTop it is like iteration we start from smaller values and iterate till we get the required number
 */
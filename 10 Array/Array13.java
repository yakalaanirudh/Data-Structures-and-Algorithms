//Find the equilibrium point

class ArrayProblems13{
    public int getEquilibriumPoint(int[] arr){
        if(arr.length==0){
            return -1;
        }

        int sum=0;
        int sum_so_far=0;

        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }

        for(int i=0;i<arr.length;i++){
            sum=sum-arr[i];

            if(sum==sum_so_far){
                return i;
            }

            sum_so_far=sum_so_far+arr[i];
        }

        return -1;
    }
}


public class Array13{
    public static void main(String[] args){
        ArrayProblems13 a=new ArrayProblems13();

        int arr[]={1,6,7,0,7};
        System.out.println(a.getEquilibriumPoint(arr));
    }
}

/*
Equilibrium point is one where the sum of numbers to the left of the index i sequal to sum of number son its right

First we find sum of all numbers and store it in sum

Then we iterate through the array from begiining at store that sum as sum _so_fat while simulatneously deleting from sum

When sum==sum_so_far that is equilibrium point

sum=20
sum so far      sum
0               20
0               19
1               13

Now when we iterate 2nd index 1+6=0+7 so equilibrium point
7               7

 */
//Largest Continguous sum
//It can be a single element or a sub array

//[-3,-4,4,-1,-2,1,5,-3]
//answer [4,-1,-2,1,5]      Sum is 7

class ArrayImpl{
    public int largestContinguousSubArrayNegative(int[] a){
        int max_so_far,current_max;
        max_so_far=current_max=0;

        for(int i=1;i<a.length;i++){
            current_max=Math.max(a[i],current_max+a[i]);
            max_so_far=Math.max(current_max,max_so_far);
        }

        return max_so_far;
    }

    public void largestContinguousSubArrayNegativeWithIndexes(int[] a){
        int max_so_far,current_max;
        max_so_far=current_max=a[0];
        int start,end,s;
        start=end=s=0;

        for(int i=1;i<a.length;i++){

            if(a[i]>current_max+a[i]){
                current_max=a[i];
                s=i;
            }else{
                current_max=current_max+a[i];
            }

            if(current_max>max_so_far){
                max_so_far=current_max;
                start=s;
                end=i;
            }
        }


        System.out.println("Max: "+max_so_far);
        System.out.println("Indexes from:"+start+" to "+end);
    }
}


public class Array10 {
    public static void main(String[] args) {
        ArrayImpl a = new ArrayImpl();

        int arr[] = {-3,-4,4,-1,-2,1,5,-3};
        System.out.println(a.largestContinguousSubArrayNegative(arr));
    }
}

/*
//[-3,-4,4,-1,-2,1,5,-3]

Current_Max=Math.max(current_max+a[i],a[i])
Max_so_far=Math.max(current_max,max_so_far)

Current_Max                             Max_so_far
-3                                      -3
-3  -4                                  -3
-3  -4  4                               4
-3  -4  4   3                           4
-3  -4  4   3   1                       4
-3  -4  4   3   1   2                   4
-3  -4  4   3   1   2   7               7
-3  -4  4   3   1   2   7   4           7

Largest Continguous sum=7
[4,-1,-2,1,5]
 */
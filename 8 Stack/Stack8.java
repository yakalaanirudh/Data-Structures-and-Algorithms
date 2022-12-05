//Here we print the next larger element in the an array

/*
[10,7,15,18,2,6,55,20]
[15,15,18,55,55,55,-1,-1]

 */

/*
[2,7,10,3,1]
[7,10,-1,-1,-1]

First we push arr[0] into stack we push 2
then we check if arr[1]>s.peek  7>2
if it is greater we pop the element from stack 2 popped
we print arr[i] which is 7
now we push that element into stack as it is to be used for next iteration  7 in stack

Now 10 is in stack
But if stack is not empty but arr[i]<stack.pop  3<10
we print -1
 */
import java.util.Stack;


class ArrayImpl {
    public void printNextLargerElements(int arr[]) {
        if (arr.length == 0) {
            return;
        }
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            while (!s.isEmpty() && arr[i] > s.peek()) {
                s.pop();
                System.out.print(arr[i] + " ");
            }
            s.push(arr[i]);                 //Push the current greater element

        }
        while (!s.isEmpty()) {
            System.out.print(-1);
            s.pop();


        }
    }
}


public class Stack8{
    public static void main(String[] args){
        ArrayImpl a=new ArrayImpl();
        int arr[]={1,4,2,6,1,8,10,15,20};           //4 6 6 8 8 10 15 20 -1

        a.printNextLargerElements(arr);
    };
}

/*
 */
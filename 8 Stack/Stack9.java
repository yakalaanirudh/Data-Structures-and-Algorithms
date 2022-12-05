//Here we get the minimum element in a stack in constant time

/*
pushing all elements in array to stack(first element bottom of stack

Now when pushing first element into stack if stack 2 is empty we push into it too

When pushing 2nd element we push into s2 if the element is less than the top of element in stack2

When we pop elements from s1 if the value is equal to s2,peek we pop from s2 too

min element is always s2.peek
 */
import java.util.Stack;

class ArrayImpl1{
    Stack<Integer> s1=new Stack<Integer>();
    Stack<Integer> s2=new Stack<Integer>();

    public void pushElementinStack(int val){
        s1.push(val);

        if(s2.isEmpty()){
            s2.push(val);
        }else{
            if(val<s2.peek()){
                s2.push(val);
            }
        }
    }

    public int popElementFromStack(){
        int val=s1.pop();

        if(val==s2.peek()){
            val=s2.pop();
        }

        return val;
    }

    public int minElement(){
        if(s2.isEmpty()){
            return -1;
        }else{
            return s2.peek();
        }
    }
}

public class Stack9{
    public static void main(String[] args){
        ArrayImpl1 a=new ArrayImpl1();

        int arr[]={7,8,3,1,5};

        for(int i=0;i<arr.length;i++){
            a.pushElementinStack(arr[i]);
        }
        System.out.print(a.minElement()+" ");

        a.popElementFromStack();
        System.out.print(a.minElement()+" ");

        a.popElementFromStack();
        System.out.print(a.minElement()+" ");
    }
}
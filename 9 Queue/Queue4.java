//Implementing Queue using stack
/*
We create two stacks
We push all elements into one stack
Then if we want to pop one
    We pop all elements from the first stack and push them into second stack and pop the first element from 2nd
    We continue this till 2nd stack is empty if we want another element
In this way we implement queue using stack
 */
import java.util.Stack;

class StackImpl{
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();

    public void enqueue(int val){
        s1.push(val);
    }

    public int dequeue() {
        if (s2.size() != 0) {
            return s2.pop();
        }

        if (s1.empty()) {
            return -1;
        }
        else {
            while (s1.size() != 0) {
                s2.push(s1.pop());
            }

            return s2.pop();
        }
    }
}

public class Queue4{
    public static void main(String[] args){
        StackImpl a=new StackImpl();

        a.enqueue(7);
        a.enqueue(3);
        a.enqueue(4);

        System.out.println(a.dequeue());
        System.out.println(a.dequeue());

        a.enqueue(7);

        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
    }
}
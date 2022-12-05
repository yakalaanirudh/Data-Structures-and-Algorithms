//Here we implement stack using queue

import java.util.LinkedList;
import java.util.Queue;

class StackImpl1{
    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();

    public void push(int val){
        q1.add(val);
    }

    public int pop(){
        if (q1.isEmpty()){
            return -1;
        }

        while (q1.size()!=1){
            q2.add(q1.remove());
        }

        int val=q1.remove();

        Queue<Integer> t=q1;
        q1=q2;
        q2=t;

        return val;
    }
}

public class Stack7{
    public static void main(String[] args){
        StackImpl1 a=new StackImpl1();

        a.push(7);
        a.push(7);
        a.push(7);

        System.out.println(a.pop());
        System.out.println(a.pop());

        a.push(7);

        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
    }
}
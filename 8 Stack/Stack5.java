//In this we implement infix to postfix to evaluation using stack

import java.util.Stack;

class StackImpl3 {
    /*
    prefix to postfix
    Infix               postfix
    2+3-1               23+1-           4
    2+3*1               231*+           5
    3*(4+5)-6/(1+2)     345+*612+/-     25

    postfix is string
    st is stack

    if the character is number we push to string
    if character is ( we push into stack
    if character is )
        and stack is not empty
        pop one element from stack( +,-,*,/,( )    if it is not ( then add it to string otherwise break
    if character is +,-,*,/
        if stack is empty push +,-,*,/ into stack
        if not pop from stack

            if popped is ( then push ( into stack
            if popped is +,-,*,/ get priority
            else string =string +popped
        push +,-,*,/ into stack

        then till stack is not empty string=string+popped
     */
    public String infixToPostfix(String s){
        Stack<Character> st=new Stack<Character>();
        String postfix="";
        char ch[]=s.toCharArray();
        for(char c:ch){
            if(c!='+' && c!='-' && c!='*' && c!='/' && c!='(' && c!=')'){
                postfix=postfix+c;
            }else if(c=='('){
                st.push(c);
            }else if(c==')'){
                while(!st.isEmpty()){
                    char t=st.pop();
                    if(t!='('){
                        postfix=postfix+t;
                    }else{
                        break;
                    }
                }
            }else if(c=='+' || c=='-' || c=='*' || c=='/'){
                if(st.isEmpty()){
                    st.push(c);
                }else{
                    while(!st.isEmpty()){
                        char t=st.pop();
                        if(t=='('){
                            st.push(t);
                            break;
                        }else if(t=='+' || t=='-' || t=='*' || t=='/'){
                            if(getPriority(t)<getPriority(c)){
                                st.push(t);
                                break;
                            }else{
                                postfix=postfix+t;
                            }
                        }
                    }
                    st.push(c);
                }
            }
        }
        while(!st.isEmpty()){
            postfix=postfix+st.pop();
        }
        return postfix;
    }


    public int getPriority(char c){
        if(c=='+' || c=='-'){
            return 1;
        }else{
            return 2;
        }
    }


    public int postfixToEvaluation(String s) {
        Stack<Integer> st=new Stack<Integer>();
        int x=0,y=0;
        char ch[]=s.toCharArray();
        for(char c:ch){
            if(c>='0' && c<='9'){
                st.push((int)(c-'0'));
            }else{
                y=st.pop();
                x=st.pop();
                switch(c){
                    case '+':
                        st.push(x+y);
                        break;
                    case '-':
                        st.push(x-y);
                        break;
                    case '*':
                        st.push(x*y);
                        break;
                    case '/':
                        st.push(x/y);
                        break;
                }
            }
        }
        return st.pop();
    }
}



public class Stack5{
    public static void main(String[] args){
        StackImpl3 a=new StackImpl3();

        String s1="2+3-1";
        System.out.println(a.infixToPostfix(s1));
        String a1=a.infixToPostfix(s1);
        System.out.println(a.postfixToEvaluation(a1));

        String s2="2+3*4";
        System.out.println(a.infixToPostfix(s2));
        String a2=a.infixToPostfix(s2);
        System.out.println(a.postfixToEvaluation(a2));

        String s3="3*(4+5)-6/(1+2)";
        System.out.println(a.infixToPostfix(s3));
        String a3=a.infixToPostfix(s3);
        System.out.println(a.postfixToEvaluation(a3));
    }
}










/*
Postfix to evaluation
Infix               postfix
2+3-1               23+1-           4
2+3*1               231*+           5
3*(4+5)-6/(1+2)     345+*612+/-     25

Logic
when there is number we put the number into stack
when there is an operator we pop two items from stack
23+1-
2 will go to stack
3 will go to stack
we see operator
pop two number 2 and 3
perform operation 2+3   5
push 5 into stack
now it is 51-
when we see minus
we pop two numbers
so we do 5-1 gives 4

231*+
2 to stack
3 to stack
1 to stack
* so pop 1 and 3 multiply 3
push 3 into stack
now stack is 32+
now when + pop 3 2 and add we get 5


345+*612+/-
push 3
push 4
push 5
+
pop 5 and 4
add 5 and 4
9
push 9 to stack
stack now 39
we see *
pop 3 and 9
3*9=27
push 27 into stack
now stack only 27
push 6,1,2
Stack 27,6,1,2
we see +
pop 2 and 1 2+1=3
stack
27,6,3
we see /
pop 6 and 3
6/3=2
now stack 27,2
now -
pop 27,2
27-2=25

 */
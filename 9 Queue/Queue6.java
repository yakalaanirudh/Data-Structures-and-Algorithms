//First non repeating character
/*
array={a,a,b,c,c,d,b,a}
result is   {a,-1,b,b,b,b,d,d}
 */
/*
First we create a hash map whose key is character and value is number of occurrences
If value returned is 1 we add it to the queue
If value later becomes 2 then we remove it from queue
getOrDefault returns value for a key if it is not mapped then we get the default (0)
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class QueueApp{
    public static void printFirstNonRepeat(char[] stream){
    HashMap<Character,Integer> map=new HashMap<>();
    Queue<Character> q=new LinkedList<>();

    for(int i=0;i<stream.length;i++){
        map.put(stream[i],map.getOrDefault(stream[i],0)+1);

        if(map.get(stream[i])==1){      //If value returned is 1 we add it to the queue
            q.add(stream[i]);
        }
        /*
        THE BELOW IS ONLY FOR WHILE LOOP
        First we add first b to q
        q is not empty
        so peek we get b
        we get map value of b it is 1 so break

        Now we add second b to map value is two
        q is not empty
        so peek we get b
        we get map value of b it is 2 so we remove b from queue
         */
        while(!q.isEmpty()){
            char c=q.peek();
            if(map.get(c)==1){
                break;
            }else{
                q.remove();
            }
        }

        if(q.isEmpty()){
            System.out.print(-1+" ");
        }else{
            System.out.print(q.peek()+" ");
        }
    }
    }
}


public class Queue6 {
    public static void main(String[] args){
        char[] stream={'a','a','b','c','c','d','b','a','d'};

        QueueApp.printFirstNonRepeat(stream);
    }
}
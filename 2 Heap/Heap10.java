//Frequency Sort elements in array

import java.util.*;

class HeapApp{
    public static String sortStringBasedOnFrequencyOfCharacters(String str){
        Map<Character,Integer> map=new HashMap<>();

        for(int i=0;i<str.length();i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap=new PriorityQueue<>((n1,n2) ->n2.getValue()-n1.getValue());

        maxHeap.addAll(map.entrySet());

        StringBuilder sb=new StringBuilder();
        while(!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> entry=maxHeap.poll();

            for(int i=0;i<entry.getValue();i++){
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}
public class Heap10{
    public static void main(String[] args){
        String str="codingSimplified";

        System.out.println(HeapApp.sortStringBasedOnFrequencyOfCharacters(str));
    }
}
//Sort an array based on frequency of value

import java.util.*;

class ArrayProblems32{
    public List<Integer> sortBasedOnFrequencyAndValue(List<Integer> list){

        Map<Integer,Integer> map=new HashMap<>();

       for(int i=0;i<list.size();i++){
           map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
       }

       Collections.sort(list,(n1,n2)->{
           int freq1=map.get(n1);
           int freq2=map.get(n2);

           if(freq1!=freq2){
               return freq2-freq1;
           }

           return n1-n2;
       });

       return list;
    }

}


public class Array32{
    public static void main(String[] args){
        ArrayProblems32 a=new ArrayProblems32();

        Integer[] arr={10,7,10,11,10,7,6,5};
        List<Integer> list=Arrays.asList(arr);
        System.out.println(a.sortBasedOnFrequencyAndValue(list));

    }
}

/*
[10,7,10,11,10,7,5,6]
[10,10,10,7,7,5,6,11] or[10,10,10,7,7,11,6,5]

We keep the frequency of the value in map
We sort map by frequency
If frequency is equal we get value
    n1-n2   for ascending
    n2-n1   for descending
*/
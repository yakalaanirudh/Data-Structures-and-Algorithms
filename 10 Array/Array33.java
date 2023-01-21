//Sort an array based on frequency of value

import java.util.*;

class ArrayProblems33{

    public List<Integer> sortBasedOnFrequencyAndIndex(List<Integer> list){

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<list.size();i++){
            map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
        }

        Collections.sort(list,(k1,k2)->{
            int freq1=map.get(k1);
            int freq2=map.get(k2);

            if(freq1!=freq2){
                return freq2-freq1;
            }

            return list.indexOf(k1)-list.indexOf(k2);
        });

        return list;
    }
}


public class Array33{
    public static void main(String[] args){
        ArrayProblems33 a=new ArrayProblems33();

        Integer[] arr={10,7,10,11,10,7,6,5};
        List<Integer> list=Arrays.asList(arr);
        System.out.println(a.sortBasedOnFrequencyAndIndex(list));
    }
}

/*
[10,7,10,11,10,7,5,6]
[10,10,10,7,7,5,6,11] or[10,10,10,7,7,11,6,5]

We keep the frequency of the value in map
We sort map by frequency
If frequency is equal   we get index
    list.indexOf(k1)-list.indexOf(k2)   for ascending
    list.indexOf(k2)-list.indexOf(k1)   for descending
*/
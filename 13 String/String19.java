//Here we print frequency of all words in a string
//The words can be printed in many ways
//Decreasing
//Random (Order in string)
//Alphabetically
//O(n) Space and Time Complexity


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class MostFrequentItemAfterExcluding3{

    public static Map<String,Integer> mostFrequent(String helpText){

        helpText=helpText.replaceAll("[^a-zA-Z0-9]"," ");
        String[] allWords=helpText.split(" +");

        Map<String, Integer> countingMap = new HashMap<>();

        for (String word : allWords) {
            word = word.toLowerCase();
            countingMap.put(word, countingMap.getOrDefault(word, 0) + 1);
        }

        //return countingMap;


        TreeMap<String, Integer> mostFrequentMap = new TreeMap<>((e1, e2) -> {
            int freq1 = countingMap.get(e1);
            int freq2 = countingMap.get(e2);

            if (freq1 != freq2) {
                return freq2 - freq1;
            }else {
                return e1.compareTo(e2);
            }
        });

        mostFrequentMap.putAll(countingMap);
        //return countingMap;       //Returns randomly


        List<String> mostFrequentWords=new ArrayList<>();
        int topFreq=mostFrequentMap.firstEntry().getValue();

        while(!mostFrequentMap.isEmpty()){
            Map.Entry<String,Integer> word=mostFrequentMap.pollFirstEntry();

            if(word.getValue()==topFreq){
                mostFrequentWords.add(word.getKey());
            }else{
                break;
            }
        }
        return mostFrequentMap;         //Returns in descensing order alphabetically if equal

    }

}

public class String19{
    public static void main(String[] args){
        String str = "Best items in category are Samsung lenovo. Samsung items are nice. Lenovo are cool";

        MostFrequentItemAfterExcluding3 a=new MostFrequentItemAfterExcluding3();


        System.out.println(a.mostFrequent(str));
    }
}



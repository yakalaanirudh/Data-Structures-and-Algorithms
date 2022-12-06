//Most frequent item in give string
/*
If more than 1 word has the highest frequency then we need to return all the words with the highest frequency
In the above case alphabetically

we convert all symbols except letters to space

We split string by " " if we have more than one space then to split we use " +"

we put all words in array to a map

In a tree map we place strings based on their frequency

pollFirstEntry()
The method call returns the removed first entry of this map, or null if this map is empty.
Suppose tree map is 1 2 3 4 5 6
after poll since first is removed
it will be 2 3 4 5 6
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class MostFrequentItemAfterExcluding{

    public static List<String> mostFrequent(String helpText){

        helpText=helpText.replaceAll("[^a-zA-Z0-9]"," ");
        String[] allWords=helpText.split(" +");

        Map<String, Integer> countingMap = new HashMap<>();

        for (String word : allWords) {
            word = word.toLowerCase();
            countingMap.put(word, countingMap.getOrDefault(word, 0) + 1);
        }

        TreeMap<String, Integer> mostFrequentMap = new TreeMap<>((e1, e2) -> {
            int freq1 = countingMap.get(e1);            //get value for the string e1
            int freq2 = countingMap.get(e2);            //get value for the string e2

            if (freq1 != freq2) {
                return freq2 - freq1;                       //descending
            }else {
                return e1.compareTo(e2);                    //if values same return alphabetically
            }
        });

        mostFrequentMap.putAll(countingMap);

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
        return mostFrequentWords;
    }

}

public class String17{
    public static void main(String[] args){
        String str = "Best items in category are Samsung lenovo. Samsung items are nice. Lenovo are cool";

        MostFrequentItemAfterExcluding a=new MostFrequentItemAfterExcluding();

        System.out.println(a.mostFrequent(str));
    }
}
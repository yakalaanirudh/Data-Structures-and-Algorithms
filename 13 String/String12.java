//Check if string contains any anagram
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class StringProblems{
     static boolean ifAnagramPresentInString(String str,String pattern){
        if(str==null || str.length()==0 || pattern ==null || pattern.length()==0){
            return false;
        }

        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            map.put(pattern.charAt(i),map.getOrDefault(pattern.charAt(i),0)+1);
        }

         int matchedElement=0;
         int start=0;

        for(int i=0;i<str.length();i++){
            char currentChar=str.charAt(i);

            if(map.containsKey(currentChar)){
                map.put(currentChar,map.get(currentChar)-1);

                if(map.get(currentChar)==0){
                    matchedElement++;
                }
            }
            if(matchedElement==map.size()){
                return true;
            }

            if(i>=pattern.length()-1){
                char charAtStart=str.charAt(start++);

                if(map.containsKey(charAtStart)){
                    if(map.get(charAtStart)==0){
                        matchedElement--;
                    }

                    map.put(charAtStart,map.get(charAtStart)+1);
                }
            }

        }
        return false;
    }
}

public class String12{
    public static void main(String[] args){
        String str="bcdcbababd";
        String pattern="abc";
        System.out.println(StringProblems.ifAnagramPresentInString(str,pattern));
    }
}
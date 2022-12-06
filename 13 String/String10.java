import java.util.HashMap;
import java.util.Map;

public class String10 {

    public static int longestSubstringLengthWithNoRepeatedCharacters(String str) {
        if(str == null || str.length() == 0) {
            return -1;
        }

        int maxLength = 0;
        int start, end;
        start = end = 0;

        Map<Character, Integer> map = new HashMap<>();

        while(end < str.length()) {
            char currentChar = str.charAt(end);

            if(map.containsKey(currentChar)) {
                start = Math.max(start, map.get(currentChar) + 1);
            }

            map.put(currentChar, end);
            maxLength = Math.max(end - start + 1, maxLength);

            end++;
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String str = "bcdcbababd";
        System.out.println(String10.longestSubstringLengthWithNoRepeatedCharacters(str));
    }

}

//To find the longest substring with no repeating characters
//"babccbacd"   4   "bacd"  "babcc/bacd/"
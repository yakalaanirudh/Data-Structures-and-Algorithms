import java.util.HashSet;
import java.util.Set;

public class String8 {

    public static int findUniqueCharactersString(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();

        for(int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        return set.size();
    }

    public static void main(String[] args) {

        String str = "bccbababd";
        System.out.println(String8.findUniqueCharactersString(str));
    }

}

//W e want to return the number of unique characters in the given string
//"abcbcacab"
//3
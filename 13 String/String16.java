public class String16 {

    private static boolean isVowel(char c) {
        if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
                || c == 'U')
            return true;

        return false;
    }

    public static String reverseVowelsInString(String str) {
        int start = 0;
        int end = str.length() - 1;

        char[] charArr = str.toCharArray();

        while (start < end) {
            if (!isVowel(charArr[start])) {
                start++;
                continue;
            }

            if (!isVowel(charArr[end])) {
                end--;
                continue;
            }

            char c = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = c;

            start++;
            end--;
        }

        return String.valueOf(charArr);
    }

    public static void main(String[] args) {
        String str = "equation";

        System.out.println(String16.reverseVowelsInString(str));
    }

}

//In this we reverse the order of vowels in the given string
//"equation"
//"oqiatuen"
//We do this by swapping and iterating from both ends
//Check if two strings with backspace are equal
/*
# means we are backspacing a character
1 # character means  one character will be deleted
We start from end of both strings

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
class Arrayapp{
    public static boolean ifStringContainsBackspace(String str1,String str2){
        int end1=str1.length()-1;
        int end2=str2.length()-1;

        while(end1>=0 &&end2>=0){
            int str1Index=getChar(str1,end1);
            int str2Index=getChar(str2,end2);

            if(str1Index<0 && str2Index<0){
                return true;
            }
            if(str1Index<0 || str2Index<0){
                return false;
            }
            if(str1.charAt(str1Index)!=str2.charAt(str2Index)){
                return false;
            }
            end1=str1Index-1;
            end2=str2Index-1;
        }
        return true;
    }

    private static int getChar(String str,int end){
        int specialChar=0;

        while(end>=0){
            if(str.charAt(end)!='#'){
                if(specialChar==0){
                    return end;
                }else{
                    specialChar--;
                }
            }else{
                specialChar++;
            }
            end--;
        }
        return end;
    }
}


public class String11{
    public static void main(String[] args){
        System.out.println(Arrayapp.ifStringContainsBackspace("bcd##e","bd#e"));
    }
}

package hard;

import java.util.HashSet;
import java.util.Set;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";
        new MinimumWindowSubstring().minWindow(s,t);
    }

    public String minWindow(String s, String t) {


        int minLength = Integer.MAX_VALUE;
        String minWord = "";
        int start = 0, end = 0;

        while (end <= s.length()){

            String substr = s.substring(start, end);

            while (substr.length() >= t.length() && containsChars(substr,t)){
                if(minLength > substr.length()){
                    minLength = substr.length();
                    minWord = substr;
                }
                start++;
                substr = s.substring(start, end);
            }
            end++;
        }


        return minWord;
    }

    public boolean containsChars(String s, String t){

        int sAlp[] = new int[128];
        int bAlp[] = new int[128];

        for (int i =0; i < s.length(); i++){
            sAlp[s.charAt(i)]++;
        }

        for (int i =0; i < t.length(); i++){
            bAlp[t.charAt(i)]++;
        }

        for (int i = 0; i < sAlp.length; i++){
            if(bAlp[i] > 0 && sAlp[i] < bAlp[i]){
                return false;
            }
        }

        return true;



    }
}

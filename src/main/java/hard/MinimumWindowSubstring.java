package hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";
        new MinimumWindowSubstring().minWindow(s,t);
    }

    public String minWindow(String s, String t) {

        int tArr[] = new int[128];

        for (int i = 0; i < t.length(); i++){
            tArr[t.charAt(i)]++;
        }

        int counter = t.length();

        int start = 0, end = 0;

        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        String minWord = "";

        while (end < s.length()){

            if(tArr[s.charAt(end)] > 0){
                counter--;
            }

            tArr[s.charAt(end)]--;

            end++;

            while (counter == 0){

                if(minLength > (end - start)){
                    minLength = (end - start);
                    minStart = start;
                    // minWord = s.substring(start,end);
                }

                char startChar = s.charAt(start);

                tArr[startChar]++;

                if(tArr[startChar]>0){
                    counter++;
                }
                start++;
            }

        }


        if(minLength == Integer.MAX_VALUE){
            return "";
        }else{
            return s.substring(minStart, minStart+ minLength);
        }

    }

}

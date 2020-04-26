package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String input = "pwwkew";
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(input);
    }

    public int lengthOfLongestSubstring(String s) {

        int longestSubstring = 0;

        int start = 0, end = 0;
        HashMap<Character, Integer> map  = new HashMap<>();

        while (end < s.length()){
            char endChar = s.charAt(end);

            if(!map.containsKey(endChar)){
                map.put(endChar, end);
                end++;
            }else{
                longestSubstring = Math.max(longestSubstring, end - start);

                //move start ahead
                int upto = map.get(endChar);
                while (start < upto){
                    map.remove(s.charAt(start++));
                }

                start = map.get(endChar) + 1;

                map.put(endChar, end);

                end++;
            }


        }

        longestSubstring = Math.max(longestSubstring, end - start);

        return longestSubstring;
    }

}

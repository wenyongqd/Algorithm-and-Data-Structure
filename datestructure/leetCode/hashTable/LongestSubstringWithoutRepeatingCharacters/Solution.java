package leetCode.hashTable.LongestSubstringWithoutRepeatingCharacters;

import java.util.*;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int index = 0;
        HashMap<Character, Integer> temp = new HashMap<>();
        for (int i = 0, j = index; i < s.length() && j < s.length(); j++) {
            if ( temp.containsKey(s.charAt(j)) ) {
                index++;
                i++;
                j = index;
                temp.clear();
            }
            ans = Math.max(ans,  j - i + 1);
            temp.put(s.charAt(j), j - i + 1 );

        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
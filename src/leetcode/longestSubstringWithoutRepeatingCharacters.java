package leetcode;

import java.util.HashMap;
import java.util.Map;

// 题号:3
public class longestSubstringWithoutRepeatingCharacters {
    /**
     * Tips: sliding window
     *
     * Time complexity: O(n)
     * Space complexity: O(min(m,n))
     * upper bounded by the size of the string n and the size of the charset/alphabet m
     * @param s: String
     * @return length of longest substring
     *
     * Example
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int res = 0;
        if (s == null || s.length() == 0) return res;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) +1, i);
            }
            map.put(s.charAt(j),j);
            res = Math.max(res, j-i+1);
        }
        return res;
    }
}

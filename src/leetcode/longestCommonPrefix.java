package leetcode;

// 题号: 14
public class longestCommonPrefix {
    /**
     * Tips:
     *
     * Time complexity: O(s), where S is the sum of all characters in all strings.
     * Space complexity: O(1)
     * Examples:
     *
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}


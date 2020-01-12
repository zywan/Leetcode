package leetcode;

// 题号: 28
public class implementStrStr {
    /**
     * Tips:
     * Quite straightforward approach -
     * move sliding window along the string and compare substring in the window with the needle.
     *
     * Time complexity: O((n-m)*m)
     * Space complexity: O(1)
     *
     * Examples:
     * Input: haystack = "hello", needle = "ll"
     * Output: 2
     * Input: haystack = "aaaaa", needle = "bba"
     * Output: -1
     */
    public int strStr(String haystack, String needle) {
        int res = -1;
        if (needle == null || needle.length() == 0) return 0;
        if (haystack == null || haystack.length() == 0) return res;
        int len1 = haystack.length();
        int len2 = needle.length();
        for (int i = 0; i <=len1-len2; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                String temp = haystack.substring(i, i + len2);
                if (temp.equals(needle)) {
                    res = i;
                    return res;
                }
            }
        }
        return res;
    }
}

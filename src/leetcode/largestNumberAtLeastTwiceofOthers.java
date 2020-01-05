package leetcode;

// 题号: 747
public class largestNumberAtLeastTwiceofOthers {
    /**
     * Tips:
     * Find the largest index and iterate the array again to check
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * Examples:
     * Input: nums = [3, 6, 1, 0]
     * Output: 1
     * Input: nums = [1, 2, 3, 4]
     * Output: -1
     */
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (j != maxIndex && nums[j] * 2 > max) return -1;
        }
        return maxIndex;
    }
}

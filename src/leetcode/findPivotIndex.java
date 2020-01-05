package leetcode;

//题号:724
public class findPivotIndex {
    /**
     * Tips:
     * Get the sum then iterate the array again
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * Examples:
     * Input:
     * nums = [1, 7, 3, 6, 5, 6]
     * Output: 3
     * Input:
     * nums = [1, 2, 3]
     * Output: -1
     */
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tmp * 2 == (sum - nums[i])) return i;
            tmp += nums[i];
        }
        return -1;
    }
}

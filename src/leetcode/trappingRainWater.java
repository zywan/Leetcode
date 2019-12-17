package leetcode;

// 题号：42
public class trappingRainWater {
    /**
     * Tips: dp
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param height height list
     * @return how much water it is able to trap after raining.
     */
    public int trap_dp(int[] height) {
        if (height == null || height.length == 0) return 0;
        int res = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        rightMax[size-1] = height[size-1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        for (int i = 1; i < size-1; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    /**
     * Tips: two pointer
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param height height list
     * @return how much water it is able to trap after raining.
     */
    public int trap_two_pointer(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        int lMax = 0;
        int rMax = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= lMax) lMax = height[l];
                else res += (lMax - height[l]);
                l++;
            }
            else {
                if (height[r] >= rMax) rMax = height[r];
                else res += (rMax - height[r]);
                r--;
            }
        }
        return res;
    }
}

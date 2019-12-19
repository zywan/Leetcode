package leetcode;

import java.util.HashMap;
import java.util.Map;

//题号: 1
public class twoSum {
    /**
     * Tips: using hashmap to store the value and index
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param nums: a list of number
     * @param target: target number
     * @return indices of the two numbers such that they add up to a specific target.
     *
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = i;
                res[1] = map.get(nums[i]);
                break;
            }
            map.put(target - nums[i], i);
        }
        return res;
    }
}



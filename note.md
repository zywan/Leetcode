## Leetcode (Sorting based on frequency)

### 1. Two sum  (easy)

#### tips 

using hashmap to store the value and index

#### code

```java
class Solution {
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
```



### 2. Add Two Numbers (medium)

#### tips

using while loop, carry out

#### code

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        int carry = 0;
        while(l1 != null || l2 !=null || carry != 0) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + carry;
            tmp.next = new ListNode(sum%10);
            carry = sum/10;
            tmp = tmp.next;
        }
        return head.next;
    }
}
```





### 42.  Trapping Rain Water (hard)

tips:

#### (1) DP

```java
class Solution {
    public int trap(int[] height) {
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
} 
```



#### (2) 
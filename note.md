## Leetcode (Sorting based on frequency)

### 1. Two sum

tips: 

using hashmap to store the value and index

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



### 2. Add Two Numbers

tips:

using while loop, carry out

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






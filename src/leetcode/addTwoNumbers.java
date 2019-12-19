package leetcode;

// 题号: 2
public class addTwoNumbers {

    // Definition for singly-linked list.
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * Tips: using while loop, pay attention to carry out
     *
     * Time complexity: O(max(m,n))
     * Space complexity: O(max(m,n))
     *
     * Example:
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */
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

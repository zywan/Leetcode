package leetcode;

// 题号:725
public class splitLinkedListInParts {

     // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
         }
     }
    /**
     * Tip:
     * If there are N nodes in the linked list root,
     * then there are N/k items in each part,
     * plus the first N%k parts have an extra item.
     *
     * Time complexity: O(n+k)
     * Space complexity: O(max(k,n))
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode temp = root;
        ListNode[] res = new ListNode[k];
        // first get the length of linked list
        while(temp!=null) {
            len++;
            temp = temp.next;
        }
        int n = len/k;
        int m = len%k;
        for (int i = 0; i < k; i++) {
            ListNode dump = new ListNode(0);
            ListNode tmp = dump;
            for (int j = 0; j < n + (i < m ? 1 : 0); j++) {
                tmp.next = new ListNode(root.val);
                tmp = tmp.next;
                if (root != null) root = root.next;
            }
            res[i] = dump.next;
        }
        return res;
    }
}

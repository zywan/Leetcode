package leetcode;

import java.util.LinkedList;
import java.util.List;

//题号: 66
public class plusOne {
    /**
     * Tips:
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Examples:
     * Input: [1,2,3]
     * Output: [1,2,4]
     */
    public int[] plusOne(int[] digits) {
        List<Integer> res = new LinkedList<>();
        int checkout = 0;
        int tmp = 0;
        for (int i = digits.length-1; i >=0;i--) {
            if (i == digits.length-1) tmp = digits[i] + checkout + 1;
            else tmp = digits[i] + checkout;
            checkout = tmp/10;
            if (checkout > 0) tmp = tmp%10;
            res.add(0, tmp);
        }
        if (checkout >0) res.add(0, checkout);
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public int[] plusOneNew(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}

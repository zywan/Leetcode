package leetcode;

//题号: 67
public class addBinary {
    /**
     * Tips:
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Examples:
     * Input: a = "11", b = "1"
     * Output: "100"
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     */
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int car = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = car;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            sb.append(sum%2);
            car = sum/2;
        }
        if (car != 0) sb.append(car);
        return sb.reverse().toString();
    }
}

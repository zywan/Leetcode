package leetcode;

import java.util.ArrayList;
import java.util.List;

//题号: 118
public class pascalTriangle {
    /**
     * Tips:
     *
     * Time complexity: O(n^2)
     * Space complexity: O(n^2)
     *
     * Examples:
     * Input: 5
     * Output:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> row = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size()-1; j++) {
                row.set(j, row.get(j) + row.get(j+1));
            }
            res.add(new ArrayList(row));
        }
        return res;
    }
}

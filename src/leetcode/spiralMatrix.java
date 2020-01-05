package leetcode;

import java.util.ArrayList;
import java.util.List;

//题号: 54
public class spiralMatrix {
    /**
     * Tips:
     * I traverse right and increment top, then traverse down and decrement right,
     * then I traverse left and decrement bottom,
     * and finally I traverse up and increment left.
     * The only tricky part is that when I traverse left or up
     * I have to check whether the row or col still exists to prevent duplicates.
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Examples:
     * Input:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * Output: [1,2,3,6,9,8,7,4,5]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) return res;

        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while(left <= right && top <= bottom){
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for(int i = right; i >= left; i--){
                    res.add(matrix[bottom][i]);
                }
            }
            bottom--;

            if (left <= right) {
                for(int i= bottom; i>= top; i--){
                    res.add(matrix[i][left]);
                }
            }
            left++;
        }
        return res;
    }
}

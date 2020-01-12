package leetcode;
// 题号:1020
public class numberOfEnclaves {
    /**
     * tips: DFS (almost same as number of island)
     * sink all the boundary island and then count the number of 1
     *
     * Time complexity: O(m*n)
     * Space complexity: O(m*n)
     */
    public int numEnclaves(int[][] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i == 0 || j ==0 || i == A.length-1 || j == A[0].length-1) {
                    findIsland(A, i, j);
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) res++;
            }
        }
        return res;
    }
    public void findIsland(int[][]A, int i, int j) {
        if (i < 0 || i > A.length-1 || j < 0 || j > A[0].length-1 || A[i][j] == 0) {
            return;
        }
        A[i][j] = 0;
        findIsland(A, i+1, j);
        findIsland(A, i-1, j);
        findIsland(A, i, j+1);
        findIsland(A, i, j-1);
    }
}

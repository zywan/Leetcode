package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 题号:886
public class possibleBipartition {
    Map<Integer, Integer> color;
    ArrayList<Integer>[] graph;

    /**
     * Tips: DFS
     *
     * Logic:
     * If the first person is red, anyone disliked by this person must be blue.
     * Then, anyone disliked by a blue person is red,
     * then anyone disliked by a red person is blue, and so on
     * If at any point there is a conflict, the task is impossible,
     * as every step logically follows from the first step.
     * If there isn't a conflict, then the coloring was valid, so the answer would be true.
     *
     * Algorithm:
     * color any node red, then all of it's neighbors blue,
     * then all of those neighbors red, and so on.
     * If we ever color a red node blue (or a blue node red), then we've reached a conflict.
     *
     * Time complexity: O(N+E)
     * Space complexity: O(N+E)
     *
     * Example:
     * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
     * Output: true
     * Explanation: group1 [1,4], group2 [2,3]
     * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
     * Output: false
     */
    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] edge:dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        color = new HashMap();
        for (int node = 1; node <= N; node++) {
            if (!color.containsKey(node) && !dfs(node, 0)) return false;
        }
        return true;
    }
    public boolean dfs(int node, int c) {
        if (color.containsKey(node)) return color.get(node) == c;
        color.put(node, c);
        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, c ^ 1)) return false;
        }
        return true;
    }
}

package leetcode;

import java.util.*;

//题号:863
public class allNodesDistanceKInBinaryTree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }


    Map<TreeNode, TreeNode> parent;

    /**
     * Tips:
     * 1. do a depth first search where we annotate every node with information about it's parent.
     * 2. breadth first search to find all nodes a distance K from the target.
     *
     * Time complexity: O(N)
     * Space complexity: O(N)
     *
     * @param root root of tree
     * @param target target TreeNode
     * @param K distance
     * @return list of the values of all nodes that have a distance K from the target node
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap();
        // assign the parents
        dfs(root, null);
        // Then BFS to search the result
        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (dist==K) {
                    List<Integer> res = new ArrayList();
                    for (TreeNode n : queue) res.add(n.val);
                    return res;
                }
                queue.offer(null);
                dist++;
            }else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }
        return new ArrayList<Integer>();
    }
    // DFS function to assign the parents
    public void dfs(TreeNode node, TreeNode par) {
        if (node!=null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
    // solution2
    class solution {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        /**
         * Tips:
         * 1. build a undirected graph using TreeNodes as vertices,
         * and the parent-child relation as edges
         * 2. do BFS with source vertices (target) to find all vertices with distance K to it.
         * Time complexity: O(N)
         * Space complexity: O(N)
         */
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> res = new ArrayList();
            if (root == null || K < 0) return res;
            buildGraph(root, null);
            if (!map.containsKey(target)) return res;
            Set<TreeNode> seen = new HashSet();
            Queue<TreeNode> queue = new LinkedList();
            queue.add(target);
            seen.add(target);
            while(!queue.isEmpty()) {
                int size = queue.size();
                if (K == 0) {
                    for (int i = 0; i < size; i++) {
                        res.add(queue.poll().val);
                    }
                    return res;
                }
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    for (TreeNode next : map.get(node)) {
                        if (seen.contains(next)) continue;
                        seen.add(next);
                        queue.add(next);
                    }
                }
                K--;
            }
            return res;
        }
        // function to build the graph based on tree
        public void buildGraph(TreeNode node, TreeNode parent) {
            if (node == null) return;
            if (!map.containsKey(node)) {
                map.put(node, new ArrayList<TreeNode>());
                if (parent != null) {
                    map.get(node).add(parent);
                    map.get(parent).add(node);
                }
                buildGraph(node.left, node);
                buildGraph(node.right, node);
            }
        }
    }
}




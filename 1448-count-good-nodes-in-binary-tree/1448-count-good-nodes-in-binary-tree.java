/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public int goodNodes(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        preorder(root, nodes, Integer.MIN_VALUE);
        return nodes.size();
    }
    
    private void preorder(TreeNode cur, List<Integer> nodes, int maxSoFar) {
        if (cur == null) return;
        
        if (cur.val >= maxSoFar) {
            nodes.add(cur.val);
        }
        
        int newMax = Math.max(maxSoFar, cur.val);
        preorder(cur.left, nodes, newMax);
        preorder(cur.right, nodes, newMax);
    }
}
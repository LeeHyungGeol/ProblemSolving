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
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        
        int pathsFromRoot = countPaths(root, targetSum);
        int pathsFromLeft = pathSum(root.left, targetSum);
        int pathsFromRight = pathSum(root.right, targetSum);
        
        return pathsFromRoot + pathsFromLeft + pathsFromRight;
    }
    
    private int countPaths(TreeNode node, long targetSum) {
        if (node == null) return 0;
        
        int count = (node.val == targetSum) ? 1 : 0;
        
        count += countPaths(node.left, targetSum - node.val);
        count += countPaths(node.right, targetSum - node.val);
        
        return count;
    }
}
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
    private int maxLength;
    public int longestZigZag(TreeNode root) {
        maxLength = 0;
        preorder(root, true, 0);
        preorder(root, false, 0);
        return maxLength;
    }

    private void preorder(TreeNode root, boolean goLeft, int curLength) {
        if (root == null) return;

        maxLength = Math.max(maxLength, curLength);

        if (goLeft) {
            preorder(root.left, true, 1);
            preorder(root.right, false, curLength+1);
        } else {
            preorder(root.left, true, curLength+1);
            preorder(root.right, false, 1);
        }
    }
}
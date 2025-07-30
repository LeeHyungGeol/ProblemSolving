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
    private boolean Answer = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        traverse(p, q);
        return Answer;
    }

    private void traverse(TreeNode pCurr, TreeNode qCurr) {
        if (pCurr == null && qCurr == null)
            return;
        if (pCurr == null || qCurr == null || pCurr.val != qCurr.val) {
            Answer = false;
            return;
        }
        traverse(pCurr.left, qCurr.left);
        traverse(pCurr.right, qCurr.right);
    }
}
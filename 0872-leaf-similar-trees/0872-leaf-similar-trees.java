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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafNodes1 = new ArrayList<>();
        List<Integer> leafNodes2 = new ArrayList<>();

        preorder(root1, leafNodes1);
        preorder(root2, leafNodes2);

        return leafNodes1.equals(leafNodes2);
    }

    private void preorder(TreeNode root, List<Integer> leafNodes) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leafNodes.add(root.val);
            return;
        }

        preorder(root.left, leafNodes);
        preorder(root.right, leafNodes);
    }
}
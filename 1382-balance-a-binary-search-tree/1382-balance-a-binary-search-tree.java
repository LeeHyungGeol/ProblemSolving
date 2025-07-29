import java.util.*;

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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraverse(inorder, root);
        return createBST(inorder, 0, inorder.size()-1);
    }

    private void inorderTraverse(List<Integer> inorder, TreeNode curr) {
        if (curr == null) {
            return;
        }
        inorderTraverse(inorder, curr.left);
        inorder.add(curr.val);
        inorderTraverse(inorder, curr.right);
    }

    private TreeNode createBST(List<Integer> inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = createBST(inorder, start, mid-1);
        root.right = createBST(inorder, mid+1, end);

        return root;
    }
}
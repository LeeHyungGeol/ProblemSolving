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
    private static Map<Integer, Integer> postIndexMap;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postIndexMap = new HashMap<>();

        for (int i = 0; i < postorder.length; ++i) {
            postIndexMap.put(postorder[i], i);
        }    

        return construct(0, preorder.length-1, 0, preorder);
    }

    private TreeNode construct(int preStart, int preEnd, int postStart, int[] preorder) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int leftRoot = preorder[preStart+1];
        int index = postIndexMap.get(leftRoot);
        int leftTreeSize = index - postStart + 1;

        root.left = construct(preStart + 1, preStart + leftTreeSize, postStart, preorder);
        root.right = construct(preStart + leftTreeSize + 1, preEnd, postStart + leftTreeSize, preorder);

        return root;
    }
}
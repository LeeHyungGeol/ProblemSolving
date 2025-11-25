/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = new ArrayList<>();
        postorder(root, p, pAncestors);

        List<TreeNode> qAncestors = new ArrayList<>();
        postorder(root, q, qAncestors);

        Set<TreeNode> set = new HashSet<>(pAncestors);

        for (TreeNode node : qAncestors) {
            if (set.contains(node)) {
                return node;
            }
        }

        return null;
    }

    private boolean postorder(TreeNode root, TreeNode target, List<TreeNode> nodes) {
        if (root == null) {
            return false;
        }

        if (root.val == target.val) {
            nodes.add(root);
            return true;
        }

        boolean foundInLeft = postorder(root.left, target, nodes);
        if (foundInLeft) {
            nodes.add(root);
            return true;
        }

        boolean foundInRight = postorder(root.right, target, nodes);
        if (foundInRight) {
            nodes.add(root);
            return true;
        }

        return false;
    }
}
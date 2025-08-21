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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(); 
        }

        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            answer.add(new ArrayList<>());

            for (int i = 0; i < size; ++i) {
                TreeNode curr = q.poll();
                answer.get(depth).add(curr.val);

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            ++depth;
        }

        return answer;
    }
}
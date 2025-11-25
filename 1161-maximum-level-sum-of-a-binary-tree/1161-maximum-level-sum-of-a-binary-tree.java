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
    public int maxLevelSum(TreeNode root) {
        int answer = 0;
        int level = 0;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            int sum = 0;
            ++level;

            for (int i = 0; i < levelSize; ++i) {
                TreeNode cur = q.poll();
                sum += cur.val;

                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }

            if (sum > maxSum) {
                maxSum = sum;
                answer = level;
            }
            
        }

        return answer;
    }
}
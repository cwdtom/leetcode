package com.github.cwdtom.leetcode;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/description/
 *
 * @author chenweidong
 */
public class ConstructStringfromBinaryTree606 {
    class Solution {
        public String tree2str(TreeNode t) {
            if (t == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            run(t, sb);
            int len = sb.length();
            return sb.delete(len - 1, len).delete(0, 1).toString();
        }

        private void run(TreeNode node, StringBuilder sb) {
            if (node != null) {
                sb.append("(").append(node.val);
                if (node.left != null && node.right != null) {
                    run(node.left, sb);
                    run(node.right, sb);
                } else if (node.left == null && node.right != null) {
                    sb.append("()");
                    run(node.right, sb);
                } else {
                    run(node.left, sb);
                }
                sb.append(")");
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

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
    public int getCount(TreeNode root,int max){
        if(root == null) return 0;
        int total = root.val >= max ? 1 : 0;
        max = Math.max(max,root.val);
        return total + getCount(root.left,max) + getCount(root.right,max);
    }
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return getCount(root,root.val);
    }
}

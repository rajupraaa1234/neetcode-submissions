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
    public int height(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(left < right){
            return right + 1;
        }else{
            return left + 1;
        }
    }
    public void makeList(TreeNode root, ArrayList<Integer> arr,int k,int h) {
        if(root == null) return;
        
        if(h == k){
            arr.add(root.val);
        }
        makeList(root.left,arr,k+1,h);
        makeList(root.right,arr,k+1,h);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int height = height(root);
        for(int i=0;i<height;i++){
            ArrayList<Integer> arr = new ArrayList<>();
            makeList(root,arr,0,i);
            res.add(arr);
        }
        return res;
    }
}

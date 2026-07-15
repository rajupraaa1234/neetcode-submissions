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
    public TreeNode makeTree(int[] preorder,int pstart,int pend,int inorder[],int instart,int inend,HashMap<Integer,Integer> map){
        if(pstart > pend || instart > inend) return null;
        int val = preorder[pstart];
        TreeNode root = new TreeNode(val);

        int inLeft = map.get(val);
        int numLeft = inLeft - instart;

        root.left = makeTree(preorder,pstart+1,pstart+inLeft,inorder,instart,inLeft-1,map);
        root.right = makeTree(preorder,pstart+numLeft+1,pend,inorder,inLeft+1,inend,map);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int n = preorder.length;
        return makeTree(preorder,0,n-1,inorder,0,n-1,map);
    }
}

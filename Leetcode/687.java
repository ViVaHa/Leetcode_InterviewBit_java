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
    int maxVal=Integer.MIN_VALUE;
    public int getMaxUnivalPath(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=0;
        int r=0;
        if(root.left!=null){
            l=getMaxUnivalPath(root.left);
        }
        if(root.right!=null){
            r=getMaxUnivalPath(root.right);
        }
        if(root.left!=null && root.left.val!=root.val){
            l=0;
        }
        if(root.right!=null && root.right.val!=root.val){
            r=0;
        }
        maxVal=Math.max(maxVal,l+r);
        return Math.max(l,r)+1;
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return 0;
        }   
        maxVal=Integer.MIN_VALUE;
        int x=getMaxUnivalPath(root);
        return maxVal;
    }
}

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
    public int subTreeBalanced(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=subTreeBalanced(root.left);
        int r=subTreeBalanced(root.right);
        if(l!=-1 && r!=-1 && Math.abs(l-r)<=1){
            return Math.max(l,r)+1;
        }
        return -1;
    } 
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return subTreeBalanced(root.left)!=-1 && subTreeBalanced(root.right)!=-1 && Math.abs(subTreeBalanced(root.left)-subTreeBalanced(root.right))<=1;
    }
}

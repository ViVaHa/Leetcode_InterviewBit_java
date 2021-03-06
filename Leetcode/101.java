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
    public boolean symmetric(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if((left==null && right!=null)||(left!=null && right==null)){
            return false;
        }
        return left.val==right.val && symmetric(left.right,right.left) && symmetric(left.left,right.right);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return symmetric(root.left,root.right);
    }
}

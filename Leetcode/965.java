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
    public boolean isUnivalTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return true;
        }
        boolean l = isUnivalTree(root.left);
        boolean r = isUnivalTree(root.right);
        if(root.left!=null){
            if(root.val!=root.left.val){
                return false;
            }
        }
        if(root.right!=null){
            if(root.val!=root.right.val){
                return false;
            }
        }
        return l&&r;
    }
}

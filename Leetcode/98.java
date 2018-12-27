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
    public boolean isBST(TreeNode root, long min, long max){
        if(root==null){
            return true;
        }
        boolean l=false;
        boolean r=false;
        if(root.val<max && root.val>min){
            l=isBST(root.left,min,root.val);
            r=isBST(root.right,root.val,max);
        }
        return l&&r;
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return isBST(root.left,Long.MIN_VALUE,root.val) && isBST(root.right,root.val,Long.MAX_VALUE);
    }
}

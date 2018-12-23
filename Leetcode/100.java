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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null && q!=null){
            return false;
        }
        if(q==null && p!=null){
            return false;
        }
        boolean l=isSameTree(p.left,q.left);
        boolean r=isSameTree(p.right,q.right);
        return p.val==q.val && l && r;
    }
}
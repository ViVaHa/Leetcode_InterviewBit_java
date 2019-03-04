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
    int count;
    public boolean getUnivalSubtrees(TreeNode root){
        if(root==null){
            return true;
        }
        boolean l = true;
        boolean r = true;
        if(root.left!=null){
            l = getUnivalSubtrees(root.left);
            if(root.val!=root.left.val){
                l=false;
            }
        }
        if(root.right!=null){
            r = getUnivalSubtrees(root.right);
            if(root.val!=root.right.val){
                r=false;
            }
        }
        if(l&&r){
            count+=1;
            return true;
        }
        return false;
    }
    public int countUnivalSubtrees(TreeNode root) {
        count=0;
        getUnivalSubtrees(root);
        return count;
    }
}

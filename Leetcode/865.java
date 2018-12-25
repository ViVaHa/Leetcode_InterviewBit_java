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
    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=depth(root.left);
        int r=depth(root.right);
        return Math.max(l,r)+1;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null){
            return null;
        }
        int l=depth(root.left);
        int r=depth(root.right);
        if(l==r){
            return root;
        }
        if(l>r){
            return subtreeWithAllDeepest(root.left);
        }
        else{
            return subtreeWithAllDeepest(root.right);
        }
    }
}

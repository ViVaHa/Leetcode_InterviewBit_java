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
    public TreeNode pruneTree(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
            if(root.val!=1){
                return null;
            }
        }
        TreeNode l=pruneTree(root.left);
        TreeNode r=pruneTree(root.right);
        if(l==null){
            root.left=null;
        }
        if(r==null){
            root.right=null;
        }
        if(l==null && r==null && root.val!=1){
            return null;
        }
        return root;
    }
}

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
    public TreeNode flattenRecursive(TreeNode root){
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
            return root;
        }
        TreeNode left=flattenRecursive(root.left);
        TreeNode right=root.right;
        TreeNode temp=root;
        if(left!=null){
            root.right=left;
            while(temp.right!=null){
                temp=temp.right;
            }
            temp.right=right;
        }
        TreeNode x=flattenRecursive(right);
        root.left=null;
        return root;
        
    }
    public void flatten(TreeNode root) {
        flattenRecursive(root);
    }
}

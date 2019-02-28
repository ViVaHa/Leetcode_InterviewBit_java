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
    public TreeNode insert(TreeNode root, int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val>val){
            TreeNode left = insert(root.left,val);
            root.left=left;
            return root;
        }else{
            TreeNode right = insert(root.right,val);
            root.right=right;
            return root;
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        root = insert(root,val);
        return root;
    }
}

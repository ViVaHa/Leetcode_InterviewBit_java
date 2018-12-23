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
    int sum=0;
    public void convert(TreeNode root){
        if(root==null){
            return;
        }
        convert(root.right);
        root.val+=sum;
        sum=root.val;
        convert(root.left);
    }
    public TreeNode convertBST(TreeNode root) {
        sum=0;
        convert(root);
        return root;
    }
}

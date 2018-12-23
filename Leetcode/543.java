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
    int maxVal=0;
    public int diameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=diameter(root.left);
        int r=diameter(root.right);
        maxVal=Math.max(maxVal,l+r);
        return Math.max(l,r)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        maxVal=0;
        int x=diameter(root);
        return maxVal;
    }
}

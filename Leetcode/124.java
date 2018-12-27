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
    static int maxVal;
    public int getMaxSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=getMaxSum(root.left);
        int r=getMaxSum(root.right);
        int maxSingle=Math.max(Math.max(l,r)+root.val,root.val);
        maxVal=Math.max(maxVal,maxSingle);
        maxVal=Math.max(maxVal,l+r+root.val);
        return maxSingle;
    }
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        maxVal=Integer.MIN_VALUE;
        int x=getMaxSum(root);
        return maxVal;
    }
}

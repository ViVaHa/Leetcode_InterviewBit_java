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
    public void getSum(TreeNode root,boolean isLeft){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null && isLeft){
            sum+=root.val;
            return;
        }
        getSum(root.left,true);
        getSum(root.right,false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        sum=0;
        getSum(root.left,true);
        getSum(root.right,false);
        return sum;
    }
}

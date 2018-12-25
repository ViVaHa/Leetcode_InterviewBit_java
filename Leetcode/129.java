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
    static int totalVal=0;
    public void getSumToLeaf(TreeNode root, int sumTillNow){
        if(root==null){
            return;
        }
        sumTillNow=sumTillNow*10+root.val;
        if(root.left==null && root.right==null){
            totalVal+=sumTillNow;
            return;
        }
        getSumToLeaf(root.left,sumTillNow);
        getSumToLeaf(root.right,sumTillNow);
    }
    public int sumNumbers(TreeNode root) {
        totalVal=0;
        if(root==null){
            return totalVal;
        }
        getSumToLeaf(root,0);
        return totalVal;
    }
}

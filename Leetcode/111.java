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
    int minVal=Integer.MAX_VALUE;
    public void getMinDepth(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            if(depth<minVal){
                minVal=depth;
            }
            return;
        }
        getMinDepth(root.left,depth+1);
        getMinDepth(root.right,depth+1);
    }
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        minVal=Integer.MAX_VALUE;
        getMinDepth(root,1);
        return minVal;
    }
}

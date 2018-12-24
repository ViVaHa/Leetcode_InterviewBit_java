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
    static int maxLevel=Integer.MIN_VALUE;
    static int retVal=-1;
    public void getBottomLeftValue(TreeNode root, int level,boolean isLeft){
        if(root==null){
            return;
        }
        if(level>maxLevel){
            maxLevel=level;
            retVal=root.val;
        }
        getBottomLeftValue(root.left,level+1,true);
        getBottomLeftValue(root.right,level+1,false);
        
    }
    public int findBottomLeftValue(TreeNode root) {
        if(root==null){
            return -1;
        }
        if(root.left==null && root.right==null){
            return root.val;
        }
        maxLevel=Integer.MIN_VALUE;
        retVal=-1;
        getBottomLeftValue(root.left,1,true);
        getBottomLeftValue(root.right,1,false);
        return retVal;
    }
}

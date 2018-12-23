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
    static int tilt=0;
    public static int getTilt(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=getTilt(root.left);
        int r=getTilt(root.right);
        tilt+=Math.abs(l-r);
        return l+r+root.val;
    }
    public int findTilt(TreeNode root) {
        if(root==null){
            return 0;
        }
        tilt=0;
        getTilt(root);
        return tilt;
    }
}

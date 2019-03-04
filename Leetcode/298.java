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
    int maxVal;
    public void getLongestConsecutiveSequence(TreeNode root, int sequenceTillNow){
        if(root==null){
            return;
        }
        if(sequenceTillNow>maxVal){
            maxVal = sequenceTillNow;
        }
        if(root.left!=null){
            if(root.left.val!=root.val+1){
                getLongestConsecutiveSequence(root.left,1);
            }else{
                getLongestConsecutiveSequence(root.left,sequenceTillNow+1);
            }
        }
        if(root.right!=null){
            if(root.right.val!=root.val+1){
                getLongestConsecutiveSequence(root.right,1);
            }else{
                getLongestConsecutiveSequence(root.right,sequenceTillNow+1);
            }
        }
    }
    public int longestConsecutive(TreeNode root) {
        maxVal = 0;
        getLongestConsecutiveSequence(root,1);
        return maxVal;
    }
}

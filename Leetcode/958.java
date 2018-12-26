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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean hasToFinishNow=false;
        while(q.size()>0){
            TreeNode node=q.poll();
            if(node==null){
                hasToFinishNow=true;
            }
            else{
                if(hasToFinishNow){
                    return false;
                }
                q.add(node.left);
                q.add(node.right);
            }
        }
        return true;
    }
}

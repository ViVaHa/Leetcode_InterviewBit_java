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
    public int findSecondMinimumValue(TreeNode root) {
        Queue<TreeNode>q = new LinkedList<>();
        if(root==null){
            return -1;
        }
        int rootVal=root.val;
        q.add(root);
        int retVal=Integer.MAX_VALUE;
        while(q.size()>0){
            TreeNode popped=q.poll();
            if(popped.val!=rootVal && popped.val<retVal){
                retVal=popped.val;
            } 
            if(popped.left!=null){
                q.add(popped.left);
                q.add(popped.right);
            }
        }
        if(retVal!=Integer.MAX_VALUE){
            return retVal;
        }
        return -1;
    }
}

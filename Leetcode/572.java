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
    public boolean subTree(TreeNode s,TreeNode t){
        if(s==null && t==null){
            return true;
        }
        if((s==null && t!=null) || (s!=null && t==null) || s.val!=t.val){
            return false;
        }
        return (subTree(s.left,t.left) && subTree(s.right,t.right));
        
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null && t==null){
            return true;
        }
        if(s==null && t!=null){
            return false;
        }
        if(subTree(s,t)){
            return true;
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }
}

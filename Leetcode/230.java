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
    static int val=-1;
    static int ind=0;
    public void inorder(TreeNode root, int k){
        if(root==null){
            return;
        }
        inorder(root.left,k);
        ind+=1;
        if(ind==k){
            val=root.val;
        }
        inorder(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return -1;
        }
        val=-1;
        ind=0;
        inorder(root,k);
        return val;
    }
}

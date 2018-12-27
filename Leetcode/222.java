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
    public int getLeftDepth(TreeNode root){
        int cnt=0;
        while(root!=null){
            root=root.left;
            cnt+=1;
        }
        return cnt;
    }
    public int getRightDepth(TreeNode root){
        int cnt=0;
        while(root!=null){
            root=root.right;
            cnt+=1;
        }
        return cnt;
    }
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l=getLeftDepth(root);
        int r=getRightDepth(root);
        if(l==r){
            return (int)Math.pow(2,l)-1;
        }
        else{
         return countNodes(root.left)+countNodes(root.right)+1;   
        }
    }
}

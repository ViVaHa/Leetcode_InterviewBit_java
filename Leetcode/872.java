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
    public static void treeTraversal(TreeNode root,StringBuilder str){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            str.append(String.valueOf(root.val));
            return;
        }
        treeTraversal(root.left,str);
        treeTraversal(root.right,str);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder leaves1=new StringBuilder("");
        StringBuilder leaves2=new StringBuilder("");
        treeTraversal(root1,leaves1);
        treeTraversal(root2,leaves2);
        return (leaves1.toString().equals(leaves2.toString()));
    }
}

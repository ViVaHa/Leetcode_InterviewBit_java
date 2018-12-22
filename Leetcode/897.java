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
    public static void inorder(TreeNode root,List<Integer>nodes){
        if(root==null){
            return;
        }
        inorder(root.left,nodes);
        nodes.add(root.val);
        inorder(root.right,nodes);
    }
    public TreeNode increasingBST(TreeNode root) {
        List<Integer>nodes=new ArrayList<>();
        if(root==null){
            return null;
        }
        inorder(root,nodes);
        TreeNode newRoot=null;
        TreeNode returnValue=null;
        for(int val:nodes){
            if(newRoot==null){
                newRoot=new TreeNode(val);
                returnValue=newRoot;
            }
            else{
                newRoot.right=new TreeNode(val);
                newRoot=newRoot.right;
            }
        }
        return returnValue;
    }
}

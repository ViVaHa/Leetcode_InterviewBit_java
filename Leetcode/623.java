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
    public TreeNode constructTree(TreeNode root,int v, int d, int level, boolean isLeft){
        if(level==d){
            TreeNode newNode=new TreeNode(v);
            if(isLeft){
                newNode.left=root;
                return newNode;
            }
            else{
                newNode.right=root;
                return newNode;
            }
        }
        if(root==null){
            return null;
        }
        root.left=constructTree(root.left,v,d,level+1,true);
        root.right=constructTree(root.right,v,d,level+1,false);
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root==null){
            return null;
        }
        if(d==1){
            TreeNode newRoot=new TreeNode(v);
            newRoot.left=root;
            return newRoot;
        }
        root.left=constructTree(root.left,v,d,2,true);
        root.right=constructTree(root.right,v,d,2,false);
        return root;
    }
}

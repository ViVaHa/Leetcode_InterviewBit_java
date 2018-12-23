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
    public boolean isLeaf(TreeNode root){
        if(root!=null && root.left==null && root.right==null){
            return true;
        }
        return false;
    }
    public void traverse(TreeNode root,StringBuilder temp,List<String> retVal){
        if(root==null){
            return;
        }
        if(isLeaf(root)){
            retVal.add(temp.append(String.valueOf(root.val)).toString());
            return;
        }
        temp.append(String.valueOf(root.val));
        temp.append("->");
        StringBuilder temp1=new StringBuilder(temp);
        StringBuilder temp2=new StringBuilder(temp);
        traverse(root.left,temp1,retVal);
        traverse(root.right,temp2,retVal);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> retVal=new ArrayList<>();
        StringBuilder temp=new StringBuilder("");
        traverse(root,temp,retVal);
        return retVal;
    }
}

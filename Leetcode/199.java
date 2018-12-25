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
    public void getRightSideView(TreeNode root,List<Integer>retVal,int level){
        if(root==null){
            return;
        }
        if(level>retVal.size()){
            retVal.add(root.val);
        }else{
            retVal.set(level-1,root.val);
        }
        getRightSideView(root.left,retVal,level+1);
        getRightSideView(root.right,retVal,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>retVal=new ArrayList<>();
        if(root==null){
            return retVal;
        }
        getRightSideView(root,retVal,1);
        return retVal;
    }
}

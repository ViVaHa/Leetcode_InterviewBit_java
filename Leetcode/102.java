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
    public void levelOrderTraversal(TreeNode root,List<List<Integer>> retVal,int level){
        if(root==null){
            return;
        }
        if(level>retVal.size()){
            List<Integer> innerList=new ArrayList<>();
            innerList.add(root.val);
            retVal.add(innerList);
        }
        else{
            retVal.get(level-1).add(root.val);
        }
        levelOrderTraversal(root.left,retVal,level+1);
        levelOrderTraversal(root.right,retVal,level+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retVal=new ArrayList<>();
        if(root==null){
            return retVal;
        }
        levelOrderTraversal(root,retVal,1);
        return retVal;
    }
}

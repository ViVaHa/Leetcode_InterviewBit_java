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
    public void getPathSum(TreeNode root,List<List<Integer>>outerList,List<Integer>innerList, int rem){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            if(rem==root.val){
                innerList.add(root.val);
                List<Integer>values=new ArrayList<>(innerList);
                outerList.add(values);
                innerList.remove(innerList.size() - 1);
            }
            return;
        }
        innerList.add(root.val);
        getPathSum(root.left,outerList,innerList,rem-root.val);
        getPathSum(root.right,outerList,innerList,rem-root.val);
        innerList.remove(innerList.size() - 1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>>outerList=new ArrayList<>();
        if(root==null){
            return outerList;
        }
        List<Integer>innerList=new ArrayList<>();
        getPathSum(root,outerList,innerList,sum);
        
        return outerList;
    }
}

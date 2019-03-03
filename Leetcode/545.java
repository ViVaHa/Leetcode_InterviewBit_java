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
    public void getLeaves(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            list.add(root.val);
            return;
        }
        getLeaves(root.left,list);
        getLeaves(root.right,list);
    }
    public void getLeftBoundary(TreeNode root, int level, List<Integer> list){
        if(root==null || (root.left==null && root.right==null)){
            return;
        }
        if(level>=list.size()){
            list.add(root.val);
        }
        if(root.left!=null){
            getLeftBoundary(root.left,level+1,list);
        }else{
            getLeftBoundary(root.right,level+1,list);
        }
    }
    public void getRightBoundary(TreeNode root, int level, List<Integer>list){
        if(root==null || (root.left==null && root.right==null)){
            return;
        }
        if(level>=list.size()){
            list.add(root.val);
        }else{
            list.set(level-1,root.val);
        }
        if(root.right!=null){
            getRightBoundary(root.right,level+1,list);
        }else{
            getRightBoundary(root.left,level+1,list);
        }
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        if(root.left==null && root.right==null){
            list.add(root.val);
            return list;
        }
        List<Integer> leftBoundary = new ArrayList<>();
        List<Integer> rightBoundary = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        getLeftBoundary(root.left,1,leftBoundary);
        getRightBoundary(root.right,1,rightBoundary);
        getLeaves(root,leaves);
        list.add(root.val);
        list.addAll(leftBoundary);
        list.addAll(leaves);
        Collections.reverse(rightBoundary);
        list.addAll(rightBoundary);
        return list;
    }
}

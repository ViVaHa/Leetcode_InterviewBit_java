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
    public List<TreeNode>generateUniqueBinarySearchTrees(int start,int end){
        if(start>end){
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }
        List<TreeNode> list = new ArrayList<>();
        for(int i=start;i<=end;i++){
            List<TreeNode> lefts = generateUniqueBinarySearchTrees(start,i-1);
            List<TreeNode> rights = generateUniqueBinarySearchTrees(i+1,end);
            for(TreeNode left:lefts){
                for(TreeNode right:rights){
                    TreeNode root = new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    list.add(root);
                }
            }  
        }
        return list;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<TreeNode>();
        }
        return generateUniqueBinarySearchTrees(1,n);
    }
}

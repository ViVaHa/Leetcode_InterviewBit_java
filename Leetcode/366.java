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
    public int pruneTree(TreeNode root, List<List<Integer>> list){
        if(root==null){
            return -1;
        }
        int l = pruneTree(root.left,list);
        int r = pruneTree(root.right,list);
        int level = Math.max(l,r)+1;
        if(list.size()==level){
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            list.add(temp);
        }else{
            list.get(level).add(root.val);
        }
        root.left = root.right = null;
        return level;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        pruneTree(root,list);
        return list;
    }
}

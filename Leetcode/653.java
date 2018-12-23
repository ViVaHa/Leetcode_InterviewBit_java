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
    public void inorder(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        Map<Integer,Boolean>map=new HashMap<>();
        for(int val:list){
            if(map.containsKey(k-val)){
                return true;
            }
            else{
                map.put(val,true);
            }
        }
        
        return false;
    }
}

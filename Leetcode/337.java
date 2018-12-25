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
    static Map<TreeNode,Integer> vals;
    public int maxRobbableValue(TreeNode root){
        if(root==null){
            return 0;
        }
        if(vals.containsKey(root)){
            return vals.get(root);
        }
        int child=0;
        int grandChild=0;
        if(root.left!=null){
            child+=maxRobbableValue(root.left);
            grandChild+=maxRobbableValue(root.left.left);
            grandChild+=maxRobbableValue(root.left.right);
        }
        if(root.right!=null){
            child+=maxRobbableValue(root.right);
            grandChild+=maxRobbableValue(root.right.left);
            grandChild+=maxRobbableValue(root.right.right);
        }
        grandChild+=root.val;
        vals.put(root,Math.max(child,grandChild));
        return Math.max(child,grandChild);
        
    }
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        vals=new HashMap<>();
        return maxRobbableValue(root);
    }
}

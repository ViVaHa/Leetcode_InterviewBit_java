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
    public String tree2str(TreeNode t) {
        if(t==null){
            return "";
        }
        if(t.left==null && t.right==null){
            return String.valueOf(t.val);
        }
        StringBuilder temp=new StringBuilder("");
        String left=tree2str(t.left);
        String right=tree2str(t.right);
        
        temp.append(String.valueOf(t.val));
        temp.append("(");
        temp.append(left);
        temp.append(")");
        if(right!=""){
            temp.append("(");
            temp.append(right);
            temp.append(")");
        }
        return temp.toString();
    }
}

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
    String ans;
    public void getSmallest(TreeNode root, StringBuilder builder){
        if(root==null){
            return;
        }
        builder.append(Character.toString((char) (root.val+97)));
        if(root.left==null && root.right==null){
            String str = builder.reverse().toString();
            if(ans.equals("") || ans.compareTo(str)>0){
                ans=str;
            }
            builder.reverse();
            builder.deleteCharAt(builder.length()-1);
            return;
        }
        getSmallest(root.left,builder);
        getSmallest(root.right,builder);
        builder.deleteCharAt(builder.length()-1);
    }
    public String smallestFromLeaf(TreeNode root) {
        ans="";
        StringBuilder builder = new StringBuilder("");
        getSmallest(root,builder);
        return ans;
    }
}

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
    public List<TreeNode> allPossibleFBT(int N) {
        if(N<=0){
            List<TreeNode>list=new ArrayList<>();
            list.add(null);
            return list;
        }
        if(N==1){
            List<TreeNode>list=new ArrayList<>();
            list.add(new TreeNode(0));
            return list;
        }
        List<TreeNode>list=new ArrayList<>();
        N=N-1;
        for(int i=1;i<N;){
            List<TreeNode> left=allPossibleFBT(i);
            List<TreeNode> right=allPossibleFBT(N-i);
            TreeNode node=null;
            for(TreeNode l:left){
                for(TreeNode r: right){
                    node=new TreeNode(0);
                    node.left=l;
                    node.right=r;
                    list.add(node);
                }
                
            }
            i+=2;
        }
        return list;
    }
}

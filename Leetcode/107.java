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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> retVal=new ArrayList<>();
        if(root==null){
            return retVal;
        }
        Stack<List<Integer>>stack=new Stack<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            List<Integer>innerList=new ArrayList<>();
            int len=q.size();
            for(int i=0;i<len;i++){
                TreeNode node=q.poll();
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                innerList.add(node.val);
            }
            stack.push(innerList);
        }
        while(stack.size()>0){
            List<Integer>inner=stack.pop();
            retVal.add(inner);
        }
        return retVal;
    }
}

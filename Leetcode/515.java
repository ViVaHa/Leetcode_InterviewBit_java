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
    public void getLargestValues(TreeNode root,List<Integer> largestValue,int level){
        if(root==null){
            return;
        }
        if(level>largestValue.size()){
            largestValue.add(root.val);
        }
        else{
            int max=largestValue.get(level-1);
            if(root.val>max){
                largestValue.set(level-1,root.val);
            }
        }
        getLargestValues(root.left,largestValue,level+1);
        getLargestValues(root.right,largestValue,level+1);
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValue=new ArrayList<>();
        if(root==null){
            return largestValue;
        }
        getLargestValues(root,largestValue,1);
        return largestValue;
    }
    
}

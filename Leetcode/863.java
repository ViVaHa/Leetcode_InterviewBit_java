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
    public void printAllDownwardNodes(TreeNode root,int k,List<Integer>retVal){
        if(root==null){
            return;
        }
        if(k==0){
            retVal.add(root.val);
            return;
        }
        printAllDownwardNodes(root.left,k-1,retVal);
        printAllDownwardNodes(root.right,k-1,retVal);
    }
    public int printAllNodes(TreeNode root, TreeNode target,int K,int level,List<Integer>retVal){
        if(root==null){
            return -1;
        }
        if(root.val==target.val){
            printAllDownwardNodes(root,K,retVal);
            return 0;
        }
        int l=printAllNodes(root.left,target,K,level+1,retVal);
        int r=printAllNodes(root.right,target,K,level+1,retVal);
        if(l!=-1){
            if(l+1==K){
                retVal.add(root.val);
            }
            else{
               printAllDownwardNodes(root.right,K-l-2,retVal); 
            }
            return l+1;
        }
        else if(r!=-1){
            if(r+1==K){
                retVal.add(root.val);
            }
            else{
               printAllDownwardNodes(root.left,K-r-2,retVal); 
            }
            return r+1;
        }
        else{
            return -1;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer>retVal=new ArrayList<>();
        if(root==null){
            return retVal;
        }
        int x=printAllNodes(root,target,K,1,retVal);
        return retVal;
    }
}

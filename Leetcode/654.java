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
    public int getMaxIndex(int[] nums,int start,int end){
        if(start>end){
            return -1;
        }
        if(start==end){
            return start;
        }
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=start;i<=end;i++){
            if(nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        return index;
    }
    public TreeNode construct(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int index=getMaxIndex(nums,start,end);
        if(index!=-1){
            TreeNode root=new TreeNode(nums[index]);
            root.left=construct(nums,start,index-1);
            root.right=construct(nums,index+1,end);
            return root;
        }
        else{
            return null;
        }
        
        
        
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0){
            return null;
        }
        return construct(nums,0,nums.length-1);
        
    }
}

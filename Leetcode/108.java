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
    public TreeNode BST(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        if(start==end){
            return new TreeNode(nums[start]);
        }
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=BST(nums,start,mid-1);
        root.right=BST(nums,mid+1,end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        int len=nums.length;
        return BST(nums,0,len-1);
    }
}

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
    static int index=0;
    public TreeNode build(int[] postorder, int[] inorder,int start,int end){
        if(start>end || index<0){
            return null;
        }
        int ind=-1;
        for(int i=start;i<=end;i++){
            if(postorder[index]==inorder[i]){
                ind=i;
                break;
            }
        }
        TreeNode root=new TreeNode(postorder[index]);
        index-=1;
        root.right=build(postorder,inorder,ind+1,end);
        root.left=build(postorder,inorder,start,ind-1);
        return root;
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0){
            return null;
        }
        index=postorder.length-1;
        return build(postorder,inorder,0,inorder.length-1);
    }
}

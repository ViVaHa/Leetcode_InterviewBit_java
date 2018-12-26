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
    public TreeNode build(int[] preorder, int[] inorder,int start,int end){
        if(start>end || index>=preorder.length){
            return null;
        }
        int ind=-1;
        for(int i=start;i<=end;i++){
            if(preorder[index]==inorder[i]){
                ind=i;
                break;
            }
        }
        TreeNode root=new TreeNode(preorder[index]);
        index+=1;
        root.left=build(preorder,inorder,start,ind-1);
        root.right=build(preorder,inorder,ind+1,end);
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        index=0;
        return build(preorder,inorder,0,inorder.length-1);
    }
}

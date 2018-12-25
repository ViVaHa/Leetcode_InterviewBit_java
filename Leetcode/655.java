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
    public int getSize(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=getSize(root.left);
        int r=getSize(root.right);
        return Math.max(l,r)+1;
    }
    public void construct(TreeNode root,int level,List<List<String>> retVal,int maxHeight){
        if(root==null){
            if(level==maxHeight){
                index+=1;
            }
            else if(level<maxHeight){
                int diff=maxHeight-level+1;
                index+=Math.pow(2,diff)-1;
                return;
            }
            return;
        }
        construct(root.left,level+1,retVal,maxHeight);
        String newString = String.valueOf(root.val);
        retVal.get(level-1).set(index,newString);
        index+=1;
        construct(root.right,level+1,retVal,maxHeight);
    }
    public List<List<String>> printTree(TreeNode root) {
        int height=getSize(root);
        int size=(int)Math.pow(2,height)-1;
        System.out.println(size);
        List<String> l=new ArrayList<>();
        for(int i=0;i<size;i++){
            l.add("");
        }
        List<List<String>> retVal=new ArrayList<>();
        for(int i=0;i<height;i++){
            List<String> newList=new ArrayList<>(l);
            retVal.add(newList);
        }
        index=0;
        construct(root,1,retVal,height);
        return retVal;
    }
}

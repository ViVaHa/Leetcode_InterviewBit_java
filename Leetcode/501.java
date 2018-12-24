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
    public static int current;
    public static int maxCount;
    public static int currentCount;
    public void inorder(TreeNode root,List<Integer>arr){
        if(root==null){
            return;
        }
        inorder(root.left,arr);
        if(current==-1){
            current=root.val;
            currentCount=1;
        }
        else if(current==root.val){
            currentCount+=1;
        }
        else{
            if(currentCount>maxCount){
                maxCount=currentCount;
                arr.clear();
                arr.add(current);
            }
            else if(currentCount==maxCount){
                arr.add(current);
            }
            currentCount=1;
            current=root.val;
        }
        inorder(root.right,arr);
    }
    public int[] findMode(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        List<Integer>arr=new ArrayList<Integer>();
        current=-1;
        maxCount=0;
        currentCount=0;
        inorder(root,arr);
        if(currentCount>maxCount){
                maxCount=currentCount;
                arr.clear();
                arr.add(current);
            }
            else if(currentCount==maxCount){
                arr.add(current);
            }
        int[] retVal = new int[arr.size()];
        for (int i =0; i < arr.size(); i++) 
            retVal[i] = arr.get(i);
        
        return retVal;
    }
}

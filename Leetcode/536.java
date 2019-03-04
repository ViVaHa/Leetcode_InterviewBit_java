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
    public TreeNode str2tree(String s) {
        //System.out.println(s);
        if(s.length()==0){
            return null;
        }
        int i=0;
        int num=0;
        boolean negative=false;
        if(s.charAt(i)=='-'){
            negative=true;
            i+=1;
        }
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            num=num*10+(s.charAt(i)-'0');
            i+=1;
        }
        if(negative){
            num*=-1;
        }
        TreeNode root = new TreeNode(num);
        int balance = 0;
        int start=i;
        int end=i;
        while(end<s.length()){
            if(s.charAt(end)=='('){
                balance+=1;
            }else if(s.charAt(end)==')'){
                balance-=1;
            }
            if(balance == 0){
                if(root.left==null){
                    root.left = str2tree(s.substring(start+1,end));
                }else{
                    root.right = str2tree(s.substring(start+1,end));
                }
                start=end+1;
            }
            end+=1;
        }
        return root;
    }
}

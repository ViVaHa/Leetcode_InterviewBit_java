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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> retVal=new ArrayList<>();
        if(root==null){
            return retVal;
        }
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode>stack2=new Stack<>();
        stack1.add(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(stack1.size()>0){
                List<Integer>innerList=new ArrayList<>();
                while(stack1.size()>0){
                    TreeNode node=stack1.pop();
                    innerList.add(node.val);
                    if(node.left!=null){
                        stack2.push(node.left);
                    }
                    if(node.right!=null){
                        stack2.push(node.right);
                    }   
                }    
                retVal.add(innerList);
            }else if(stack2.size()>0){
                List<Integer>innerList=new ArrayList<>();
                while(stack2.size()>0){
                    TreeNode node=stack2.pop();
                    innerList.add(node.val);
                    if(node.right!=null){
                        stack1.push(node.right);
                    }
                    if(node.left!=null){
                        stack1.push(node.left);
                    }
                }
                retVal.add(innerList);
            }
        }
        return retVal;
    }
}

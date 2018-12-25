/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    Stack<TreeNode>stack;
    
    public BSTIterator(TreeNode root) {
        stack=new Stack<>();
        pushEverything(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node=stack.pop();
        pushEverything(node.right);
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public void pushEverything(TreeNode root){
        if(root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

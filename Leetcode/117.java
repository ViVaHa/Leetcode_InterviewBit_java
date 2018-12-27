/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeLinkNode getNext(TreeLinkNode root){
        if(root==null){
            return null;
        }
        TreeLinkNode ret=null;
        while(root!=null){
            if(root.left!=null)
                return root.left;
            if(root.right!=null)
                return root.right;
            root=root.next;
        } 
        return null;

    }
    public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        root.next=null;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            TreeLinkNode node=q.poll();
            if(node.left!=null){
                if(node.right!=null){
                    node.left.next=node.right;
                }
                else{
                    node.left.next=getNext(node.next);
                    
                }
            }
            if(node.right!=null){
                node.right.next=getNext(node.next);
            }
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
        }
    }
}

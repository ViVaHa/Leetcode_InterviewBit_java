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
        if(root.left!=null){
            return root.left;
        }else if(root.right!=null){
            return root.right;
        }else{
         return getNext(root.next);   
        }
    }
    public void connectNextPointer(TreeLinkNode root){
        if(root==null){
            return ;
        }
        if(root.left!=null){
            if(root.right!=null){
                root.left.next=root.right;
            }
            else{
                root.left=getNext(root.next);
            }
        }
        if(root.right!=null){
            root.right.next=getNext(root.next);
        }
        if(root.left!=null){
            connectNextPointer(root.left);
        }
        if(root.right!=null){
            connectNextPointer(root.right);
        }
    }
    public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        root.next=null;
        connectNextPointer(root);
    }
}

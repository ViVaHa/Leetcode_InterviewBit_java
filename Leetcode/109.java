/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public static ListNode[] getMiddleNodes(ListNode head){
        if(head==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        
        return new ListNode[]{prev,slow};
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode[] ele=getMiddleNodes(head);
        if(ele[0]!=null){
            ele[0].next=null;
        }
        TreeNode root=new TreeNode(ele[1].val);
        if(ele[0]!=null){
            root.left=sortedListToBST(head);
        }
        root.right=sortedListToBST(ele[1].next);
        return root;
    }
}

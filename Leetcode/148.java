/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static ListNode merge(ListNode left,ListNode right){
        if(left==null && right==null){
            return null;
        }
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(left!=null && right!=null){
            if(left.val<right.val){
                curr.next=new ListNode(left.val);
                curr=curr.next;
                left=left.next;
            }
            else{
                curr.next=new ListNode(right.val);
                curr=curr.next;
                right=right.next;
            }
        }
        if(left!=null){
            curr.next=left;
        }
        if(right!=null){
            curr.next=right;
        }
        return dummy.next;
    }
    public static ListNode mergeSort(ListNode head){
        if(head==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(prev!=null){
            prev.next=null;
            ListNode leftHalf=mergeSort(head);
            ListNode rightHalf=mergeSort(slow);
            head=merge(leftHalf,rightHalf);
            return head;
        }
        return head;
        
    }
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        return mergeSort(head);
        
    }
}

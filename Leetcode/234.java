/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=slow;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        prev.next=null;
        ListNode middle=slow;
        ListNode rev=reverse(middle);
        while(head!=null){
            if(head.val!=rev.val){
                return false;
            }
            head=head.next;
            rev=rev.next;
        }
        return true;
    }
}

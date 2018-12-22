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
        if(head==null){
            return null;
        }
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        if(slow==fast){
            return;
        }
        prev.next=null;
        ListNode reversedList=reverse(slow);
        ListNode curr=head;
        ListNode next=null;
        ListNode temp=null;
        while(curr!=null){
            prev=reversedList;
            next=curr.next;
            temp=reversedList.next;
            curr.next=reversedList;
            reversedList.next=next;
            curr=next;
            reversedList=temp;
        }
        if(temp!=null){
            prev.next=temp;
        }
    }
}

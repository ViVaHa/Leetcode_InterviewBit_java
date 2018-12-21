/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=curr.next;
        while(curr!=null){
            if(next!=null && curr.val==next.val){
                    while(next!=null && curr.val==next.val){
                        curr=curr.next;
                        next=curr.next;
                    }
                if(prev!=null){
                    prev.next=next;
                }
                else{
                    head=next;
                }
                curr=next;
                if(curr!=null){
                    next=curr.next;
                }
                
            }
            else{
                prev=curr;
                curr=curr.next;
                if(curr!=null){
                    next=curr.next;
                }
                
            }
        }
        return head;
    }
}

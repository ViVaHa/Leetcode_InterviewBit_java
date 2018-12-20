/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode prev=head;
        ListNode curr=head.next;
        ListNode next=null;
        if(curr!=null){
            next=curr.next;
        }
        if(curr!=null){
            curr.next=prev;
        }
        else{
            return prev;
        }
        prev.next=swapPairs(next);
        return curr;
    }
}

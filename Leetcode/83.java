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
        ListNode curr=head;
        ListNode next=curr.next;
        while(curr!=null){
            while(next!=null && curr.val==next.val){
                next=next.next;
            }
            curr.next=next;
            curr=curr.next;
        }
        return head;
    }
}

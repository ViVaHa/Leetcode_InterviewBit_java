/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        ListNode curr=head;
        ListNode prev=null;
        for(int i=0;i<n;i++){
            curr=curr.next;
        }
        ListNode start=head;
        while(curr!=null){
            prev=start;
            start=start.next;
            curr=curr.next;
        }
        if(prev==null){
            return head.next;
        }
        prev.next=start.next;
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }
        ListNode lesserHead=new ListNode(0);
        ListNode greaterHead=new ListNode(0);
        ListNode curr=head;
        ListNode lesser=lesserHead;
        ListNode greater=greaterHead;
        while(curr!=null){
            if(curr.val>=x){
                greater.next=new ListNode(curr.val);
                greater=greater.next;
            }
            else{
                lesser.next=new ListNode(curr.val);
                lesser=lesser.next;
            }
            curr=curr.next;
        }
        greaterHead=greaterHead.next;
        lesser.next=greaterHead;
        return lesserHead.next;
    }
}

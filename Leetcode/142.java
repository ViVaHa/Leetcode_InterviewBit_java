/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode slow=head.next;
        ListNode fast=head.next.next;
        while(fast!=null && fast.next!=null && slow!=fast){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast==null){
            return null;
        }
        slow=head;
        System.out.println(slow.val);
        System.out.println(fast.val);
        while(fast!=null && slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        if(fast==null){
            return null;
        }
        return fast;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        while(head!=null && head.val==val){
            head=head.next;
        }
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;
        while(curr!=null){
            if(curr.val==val){
                while(curr!=null && curr.val==val){
                    next=curr.next;
                    curr=curr.next;
                }
                prev.next=next;
            }else{
                prev=curr;
                curr=curr.next;
            }
        
        }
        return head;
    }
}

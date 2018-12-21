/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null){
            return null;
        }
        if(m==n){
            return head;
        }
        
        ListNode pre=null;
        int i;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=dummy;
        for(i=0;i<m;i++){
            pre=curr;
            curr=curr.next;
        }
        ListNode prev=null;
        ListNode next=null;
        ListNode tail=curr;
        while(i<=n && curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            i+=1;
        }
        if(pre!=null){
            pre.next=prev;
        }
        tail.next=next;
        return dummy.next;
    }
}

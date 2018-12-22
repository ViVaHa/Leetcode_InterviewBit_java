/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int count=0;
        ListNode curr=head;
        while(curr!=null){
            count+=1;
            curr=curr.next;
        }
        if(k>=count){
            k=k%count;
        }
        if(k==0){
            return head;
        }
        curr=head;
        for(int i=0;i<k;i++){
            curr=curr.next;
        }
        ListNode newHead=head;
        ListNode prev=null;
        while(curr!=null){
            prev=newHead;
            curr=curr.next;
            newHead=newHead.next;
        }
        prev.next=null;
        curr=newHead;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=head;
        return newHead;
    }
}

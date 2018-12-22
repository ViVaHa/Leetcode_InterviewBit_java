/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static ListNode reverse(ListNode head, int k,int cnt){
        if(head==null||cnt<k){
            return head;
        }
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        int i=0;
        while(curr!=null && i<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            i+=1;
        }
        ListNode newList=prev;
        while(newList.next!=null){
            newList=newList.next;
        }
        newList.next=reverse(curr,k,cnt-k);
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==0||head==null){
            return head;
        }
        int cnt=0;
        ListNode curr=head;
        while(curr!=null){
            cnt+=1;
            curr=curr.next;
        }
        return reverse(head,k,cnt);
    }
}

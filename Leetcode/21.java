/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head=null;
        if(l1.val<l2.val){
            head=l1;
            l1=l1.next;
        }
        else{
            head=l2;
            l2=l2.next;
        }
        ListNode ret=head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                head.next=l1;
                l1=l1.next;
            }
            else{
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        if(l1!=null){
            head.next=l1;
        }
        if(l2!=null){
            head.next=l2;
        }
        return ret;
    }
}

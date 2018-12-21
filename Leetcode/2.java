/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        int carry=0;
        ListNode result=null;
        ListNode head=null;
        while(l1!=null && l2!=null){
            int val=l1.val+l2.val+carry;
            carry=val/10;
            if(result!=null){
                ListNode now=new ListNode(val%10);
                result.next=now;
                result=result.next;
            }
            else{
                result=new ListNode(val%10);
                head=result;
            }
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int val=l1.val+carry;
            carry=val/10;
            ListNode now=new ListNode(val%10);
            result.next=now;
            result=result.next;
            l1=l1.next;
        }
        while(l2!=null){
            int val=l2.val+carry;
            carry=val/10;
            ListNode now=new ListNode(val%10);
            result.next=now;
            result=result.next;
            l2=l2.next;
        }
        if(carry>0){
            ListNode now=new ListNode(carry);
            result.next=now;
        }
        return head;
    }
}

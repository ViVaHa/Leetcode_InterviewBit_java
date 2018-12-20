/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode odd=null;
        ListNode even=null;
        ListNode oddHead=null;
        ListNode evenHead=null;
        int a=1;
        while(head!=null){
            if(a%2==1){
                if(odd==null){
                    odd=new ListNode(head.val);
                    oddHead=odd;
                }
                else{
                    ListNode newOdd=new ListNode(head.val);
                    odd.next=newOdd;
                    odd=newOdd;
                }
            }
            else{
                if(even==null){
                    even=new ListNode(head.val);
                    evenHead=even;
                }
                else{
                    ListNode newEven=new ListNode(head.val);
                    even.next=newEven;
                    even=newEven;
                }
            }
            a+=1;
            head=head.next;
        }
        odd.next=evenHead;
        return oddHead;
        
    }
}

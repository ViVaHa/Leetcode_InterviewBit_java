/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1=0;
        int count2=0;
        ListNode currA=headA;
        ListNode currB=headB;
        while(currA!=null){
            currA=currA.next;
            count1+=1;
        }
        while(currB!=null){
            currB=currB.next;
            count2+=1;
        }
        if(count1>count2){
            while(count1!=count2){
                count1-=1;
                headA=headA.next;
            }
        }
        else{
            while(count1!=count2){
                count2-=1;
                headB=headB.next;
            }
        }
        while(headA!=null && headB!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}

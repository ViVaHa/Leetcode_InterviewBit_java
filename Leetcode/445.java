/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int carry=0;
    public static ListNode addEqualElements(ListNode l1,ListNode l2,Solution sol){
        if(l1==null && l2==null){
            return null;
        }
        ListNode next=addEqualElements(l1.next,l2.next,sol);
        int val=l1.val+l2.val+sol.carry;
        sol.carry=val/10;
        ListNode now=new ListNode(val%10);
        now.next=next;
        return now;
    }
    public static ListNode addRemaining(ListNode l1,Solution sol,int diff){
        ListNode next=null;
        if(diff>1){
            next=addRemaining(l1.next,sol,diff-1);
        }
        int val=l1.val+sol.carry;
        sol.carry=val/10;
        ListNode now=new ListNode(val%10);
        now.next=next;
        return now;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Solution sol=new Solution();
        sol.carry=0;
        int cnt1=0;
        int cnt2=0;
        ListNode curr1=l1;
        ListNode curr2=l2;
        while(curr1!=null){
            cnt1+=1;
            curr1=curr1.next;
        }
        while(curr2!=null){
            cnt2+=1;
            curr2=curr2.next;
        }
        curr1=l1;
        curr2=l2;
        int diff=cnt2-cnt1;
        boolean firstBigger=false;
        if(diff>0){
            while(diff>0){
                diff-=1;
                curr2=curr2.next;
            }
        }
        else{
            firstBigger=true;
            while(diff<0){
                diff+=1;
                curr1=curr1.next;
                
            }
        }
        ListNode added=addEqualElements(curr1,curr2,sol);
        if(cnt1==cnt2){
            if(sol.carry>0){
                ListNode newHead=new ListNode(sol.carry);
                newHead.next=added;
                return newHead;
            }
            return added;
        }
        //System.out.println(added.val);
        if(firstBigger){
            ListNode rem=addRemaining(l1,sol,cnt1-cnt2);
            ListNode current=rem;
            while(current.next!=null){
                current=current.next;
            }
            current.next=added;
            ListNode newHead=rem;
            if(sol.carry>0){
                newHead=new ListNode(sol.carry);
                newHead.next=rem;
            }
            return newHead;
        }
        else{
            ListNode rem=addRemaining(l2,sol,cnt2-cnt1);
            ListNode current=rem;
            while(current.next!=null){
                current=current.next;
            }
            current.next=added;
            ListNode newHead=rem;
            if(sol.carry>0){
                newHead=new ListNode(sol.carry);
                newHead.next=rem;
            }
            return newHead;
        }
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] parts=new ListNode[k];
        ListNode curr=root;
        int cnt=0;
        while(curr!=null){
            cnt+=1;
            curr=curr.next;
        }
        int rem=0;
        if(cnt>k){
            rem=cnt%k;
        }
        int individualPart=cnt/k;
        curr=root;
        int t=0;
        int i;
        while(t<k && curr!=null){
            parts[t]=curr;
            ListNode prev=curr;
            curr=curr.next;
            for(i=1;i<individualPart;i++){
                prev.next=curr;
                prev=curr;
                curr=curr.next;
                
            }
            if(rem>0){
                prev.next=curr;
                prev=curr;
                curr=curr.next;
                rem-=1;
            }
            prev.next=null;
            t+=1;
        }
        return parts;
    }
}

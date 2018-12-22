/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        boolean stopIteration=true;
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        int index=-1;
        while(true){
            int min=Integer.MAX_VALUE;
            stopIteration=true;
            for(int i=0;i<lists.length;i++){
                if(lists[i]!=null){
                    stopIteration=false;
                    if(lists[i].val<min){
                        min=lists[i].val;
                        index=i;
                    }
                }
            }
            if(!stopIteration){
                curr.next=new ListNode(min);
                curr=curr.next;
                lists[index]=lists[index].next;
            }
            else{
                break;
            }
        }
        return dummy.next;
    }
}

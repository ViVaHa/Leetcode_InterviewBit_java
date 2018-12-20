/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        boolean start=false;
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<G.length;i++){
            set.add(G[i]);
        }
        int count=0;
        ListNode curr=head;
        while(curr!=null){
            if(set.contains(curr.val)){
                if(!start){
                    start=true;
                }
            }
            else{
                if(start){
                    count+=1;
                    start=false;
                }
            }
            curr=curr.next;
        }
        if(start){
            count+=1;
        }
        return count;
    }
}

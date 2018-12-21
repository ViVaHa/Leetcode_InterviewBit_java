/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head==null){
            return null;
        }
        Node curr=head;
        while(curr!=null){
            if(curr.child!=null){
                Node child=curr.child;
                Node traverse=curr.child;
                Node next=curr.next;
                while(traverse.next!=null){
                    traverse=traverse.next;
                }
                child.prev=curr;
                curr.next=child;
                if(next!=null){
                    next.prev=traverse;
                }
                traverse.next=next;
                curr.child=null;
            }
            curr=curr.next;
        }
        return head;
    }
}

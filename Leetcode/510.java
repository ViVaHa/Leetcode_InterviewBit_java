/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    public Node inorderSuccessor(Node x) {
        if(x==null){
            return null;
        }
        if(x.right!=null){
            x=x.right;
            while(x.left!=null){
                x=x.left;
            }
            return x;
        }else{
            Node ret=x.parent;
            while(ret!=null && ret.val<x.val){
                ret = ret.parent;
            }
            return ret;
        }
    }
}

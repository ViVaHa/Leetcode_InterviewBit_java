/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public static void preOrder(Node root,List<Integer>finalList){
        if(root==null){
            return;
        }
        finalList.add(root.val);
        for(Node child:root.children){
            preOrder(child,finalList);
        }
        
    }
    public List<Integer> preorder(Node root) {
        List<Integer>finalList=new ArrayList<>();
        preOrder(root,finalList);
        return finalList;
    }
}

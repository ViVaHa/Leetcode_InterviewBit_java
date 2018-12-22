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
    public List<Integer>finalList;
    public static void postOrder(Node root,Solution sol){
        if(root==null){
            return;
        }
        for(Node child:root.children){
            postOrder(child,sol);
        }
        sol.finalList.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        Solution sol=new Solution();
        sol.finalList=new ArrayList<>();
        postOrder(root,sol);
        return sol.finalList;
    }
}

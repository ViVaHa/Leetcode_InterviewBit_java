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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> outerList=new ArrayList<>();
        if(root==null){
            return outerList;
        }
        
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int level=0;
        while(q.size()>0){
            List<Integer> innerList=new ArrayList<>();
            int len=q.size();
            for(int i=0;i<len;i++){
                Node node=q.poll();
                if(node!=null){
                    innerList.add(node.val);
                    for(Node child:node.children){
                        q.add(child);
                    }
                }
            }
            outerList.add(innerList);
        }
        return outerList;
    }
}

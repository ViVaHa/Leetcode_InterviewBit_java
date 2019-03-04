/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode search(TreeNode root, int key, Map<TreeNode, TreeNode> map){
        if(root==null){
            return null;
        }
        if(root.val==key){
            return root;
        }
        if(root.left!=null){
            map.put(root.left,root);
        }
        if(root.right!=null){
            map.put(root.right,root);
        }
        TreeNode left = search(root.left,key,map);
        TreeNode right = search(root.right,key,map);
        if(left!=null){
            return left;
        }else{
            return right;
        }
    }
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode node = search(root, k,map);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        visited.add(node);
        queue.add(node);
        while(!queue.isEmpty()){
            node = queue.poll();
            if(node.left==null && node.right==null){
                return node.val;
            }
            if(node.left!=null && !visited.contains(node.left)){
                queue.add(node.left);
                visited.add(node.left);
            }
            if(node.right!=null && !visited.contains(node.right)){
                queue.add(node.right);
                visited.add(node.right);
            }
            if(map.containsKey(node) && !visited.contains(map.get(node))){
                queue.add(map.get(node));
                visited.add(map.get(node));
            }
        }
        return -1;
    }
}

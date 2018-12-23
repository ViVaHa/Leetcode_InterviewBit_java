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
    public static void traverse(TreeNode root,int level, Map<Integer,List<Integer>> map){
        if(root==null){
            return;
        }
        traverse(root.left,level+1,map);
        traverse(root.right,level+1,map);
        if(map.containsKey(level)){
            List<Integer>nodes=map.get(level);
            nodes.add(root.val);
            map.put(level,nodes);
        }
        else{
            List<Integer>nodes=new ArrayList<Integer>();
            nodes.add(root.val);
            map.put(level,nodes);
        }
        
    }
    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer,List<Integer>>map=new TreeMap<>();
        traverse(root,0,map);
        List<Double>average=new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>>entry:map.entrySet()){
            double sum=0;
            for(int val:entry.getValue()){
                sum+=val;
            }
            average.add(sum/entry.getValue().size());
        }
        return average;
    }
}

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
    static int maxTimes=0;
    public int getSums(TreeNode root,Map<Integer,Integer>map){
        if(root==null){
            return 0;
        }
        int l=getSums(root.left,map);
        int r=getSums(root.right,map);
        if(map.containsKey(l+r+root.val)){
            map.put(l+r+root.val,map.get(l+r+root.val)+1);
        }
        else{
            map.put(l+r+root.val,1);
        }
        return l+r+root.val;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        ArrayList<Integer> vals=new ArrayList<>();
        Map<Integer,Integer>map=new HashMap<>();
        int sum=getSums(root,map);
        ArrayList<Integer>finalVals=new ArrayList<>(); 
        
        Map.Entry<Integer,Integer>maxEntry=null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
                finalVals.clear();
                finalVals.add(entry.getKey());
            }
            else if(entry.getValue().compareTo(maxEntry.getValue()) == 0){
                finalVals.add(entry.getKey());
            }
        }
        int[] ret=new int[finalVals.size()];
        for(int i=0;i<finalVals.size();i++){
            ret[i]=finalVals.get(i);
        }
        return ret;
    }
}

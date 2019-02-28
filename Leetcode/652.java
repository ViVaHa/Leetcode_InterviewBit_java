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
    public String getAllSubTrees(TreeNode root, Map<String,Integer> stringMap, Set<TreeNode> treeNodeSet){
        if(root==null){
            return " ";
        }
        String left = getAllSubTrees(root.left,stringMap,treeNodeSet);
        String right = getAllSubTrees(root.right,stringMap,treeNodeSet);
        StringBuilder builder = new StringBuilder(left);
        builder.append(right);
        builder.append(String.valueOf(root.val));
        String retVal = builder.toString();
        if(stringMap.get(retVal)==null){
            stringMap.put(retVal,1);
        }else{
            if(stringMap.get(retVal)==1){
                treeNodeSet.add(root);
            }
            stringMap.put(retVal,stringMap.get(retVal)+1);
        }
        return builder.toString();
    } 
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<TreeNode> treeNodeSet = new HashSet<>();
        List<TreeNode> retVal = new ArrayList<>();
        if(root==null){
            return retVal;
        }
        HashMap<String,Integer> stringMap = new HashMap<>();
        String ret = getAllSubTrees(root,stringMap,treeNodeSet);
        retVal.addAll(treeNodeSet);
        return retVal;
    }
}

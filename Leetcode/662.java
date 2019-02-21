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
    public List<Integer> leftMostNodes;
    public List<Integer> rightMostNodes;
    public void getWidthOfBinaryTree(TreeNode root, int level, int line, List<Integer> leftMostNodes, List<Integer> rightMostNodes){
        if(root==null){
            return;
        }
        if(level>=leftMostNodes.size()){
            leftMostNodes.add(line);
        }
        if(level>=rightMostNodes.size()){
            rightMostNodes.add(line);
        }
        if(level<leftMostNodes.size()){
            if(leftMostNodes.get(level)>line){
                leftMostNodes.set(level,line);
            }
        }
        if(level<rightMostNodes.size()){
            if(rightMostNodes.get(level)<line){
                rightMostNodes.set(level,line);
            }
        }
        getWidthOfBinaryTree(root.left,level+1,2*line, leftMostNodes, rightMostNodes);
        getWidthOfBinaryTree(root.right,level+1,2*line+1, leftMostNodes, rightMostNodes);        
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        leftMostNodes = new ArrayList<>();
        rightMostNodes = new ArrayList<>();
        getWidthOfBinaryTree(root,0,1,leftMostNodes, rightMostNodes);
        int maxVal = Integer.MIN_VALUE;
        for(int i=0;i<Math.min(leftMostNodes.size(),rightMostNodes.size());i++){
            //System.out.println(leftMostNodes.get(i) + " " + rightMostNodes.get(i));
            maxVal = Math.max(maxVal,rightMostNodes.get(i)-leftMostNodes.get(i)+1);
        }
        return maxVal;
    }
}

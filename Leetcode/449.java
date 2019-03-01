/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return String.valueOf(root.val) +" " + left+ " " +right;
    }
    public TreeNode deserializeHelper(String[] data){
        if(index>=data.length || data[index].equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[index]));
        index+=1;
        root.left = deserializeHelper(data);
        index+=1;
        root.right = deserializeHelper(data);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        index=0;
        String[] vals = data.split(" ");
        return deserializeHelper(vals);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

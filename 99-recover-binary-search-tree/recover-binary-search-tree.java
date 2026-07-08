/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int idx=0;
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        inOrder(root,res);
        Collections.sort(res);
        swapNode(root,res);
    }

    void inOrder(TreeNode root,ArrayList<Integer> res){
        if(root==null) return ;
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }

    void swapNode(TreeNode root,ArrayList<Integer> res){
        if(root==null) return ;
        swapNode(root.left,res);
        root.val=res.get(idx++);
        swapNode(root.right,res);
    }
}
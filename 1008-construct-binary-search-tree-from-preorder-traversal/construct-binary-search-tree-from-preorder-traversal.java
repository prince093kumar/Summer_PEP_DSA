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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0){
            return null;
        }
        TreeNode root=new TreeNode(preorder[0]);
        if(preorder.length==1){
           return root;
        }

        for(int i=1;i<preorder.length;i++){
            TreeNode newNode=new TreeNode(preorder[i]);
            buildBST(root,newNode);
        }
        return root;
    }

    void buildBST(TreeNode root,TreeNode newNode){
        TreeNode curr=root;

        while(true){
            if(curr.val>newNode.val){
                if(curr.left==null){
                    curr.left=newNode;
                    break;
                }
                curr=curr.left;
            }
            else{
                if(curr.right==null){
                    curr.right=newNode;
                    break;
                }
                curr=curr.right;
            }
        }
    }
}
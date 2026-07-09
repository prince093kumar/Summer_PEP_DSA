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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        inOrderTraversal(root,res);
        return BalancedBST(res,0,res.size()-1);
        
    }

    public TreeNode BalancedBST(ArrayList<Integer> arr,int low,int high){
        if(low>high){
            return null;
        }
        int mid=low+(high-low)/2;
        TreeNode root=new TreeNode(arr.get(mid));
        TreeNode leftNode=BalancedBST(arr,low,mid-1);
        TreeNode rightNode=BalancedBST(arr,mid+1,high);
        root.left=leftNode;
        root.right=rightNode;
        return root;
    }

     void inOrderTraversal(TreeNode root,ArrayList<Integer> res){
        if(root==null){
            return ;
        }
        inOrderTraversal(root.left,res);
        res.add(root.val);
        inOrderTraversal(root.right,res);
    }
}
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int queSize=que.size();
            ArrayList<Integer> ans=new ArrayList<>();
            for(int i=0;i<queSize;i++){
                TreeNode peek=que.poll();
                if(peek.left!=null){
                    que.offer(peek.left);
                }
                if(peek.right!=null){
                    que.offer(peek.right);
                }
                ans.add(peek.val);
            }
            res.add(ans);
        }
        return res;
    }
}
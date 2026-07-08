class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        backtrack(candidates,target,res,ans,0);
        return res;
    }

    public void backtrack(int[] candidates,int target,List<List<Integer>> res,ArrayList<Integer> ans,int idx){
        if(target==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(target<0 || idx==candidates.length){
            return;
        }

        ans.add(candidates[idx]);
        backtrack(candidates,target-candidates[idx],res,ans,idx);
        ans.remove(ans.size()-1);
        backtrack(candidates,target,res,ans,idx+1);
    }
}
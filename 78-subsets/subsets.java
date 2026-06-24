class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        subSet(nums,result,ans,0);
        return result;
    }
    public void subSet(int[] nums,List<List<Integer>> res,List<Integer> ans,int idx){
        if(idx==nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        // pick
        ans.add(nums[idx]);
        subSet(nums,res,ans,idx+1);

        // not pick
        ans.remove(ans.size()-1);
        subSet(nums,res,ans,idx+1);
        
    }
}
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int case1= maxRob(nums,0,n-2);
        int case2= maxRob(nums,1,n-1);
        return Math.max(case1,case2);
    }

    public int maxRob(int[] nums,int i,int j){
        // only one house availabe for rob.
        if(i==j){
            return nums[i];
        }
        int prev2=nums[i];
        int prev1=Math.max(nums[i+1],nums[i]);
        int curr;
        for(int k=i+2;k<=j;k++){
            curr=Math.max(prev1,prev2+nums[k]);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }

}
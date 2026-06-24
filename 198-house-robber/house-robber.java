class Solution {
    public int rob(int[] nums) {
        // int[] dp=new int[nums.length];
        // Arrays.fill(dp,-1);
        // return houseRob(nums,dp,nums.length-1);
        return houseRob(nums,nums.length);
    }

    // public int houseRob(int[] nums,int[] dp,int n){
    public int houseRob(int[] nums,int n){
        // if(n<0){
        //     return 0;
        // }
        // if(n==0){
        //     return nums[n];
        // }
        if(n==1){
            return nums[0];
        }
        // dp[0]=nums[0];
        // dp[1]=Math.max(nums[0],nums[1]);

        // if(dp[n]!=-1){
        //     return dp[n];
        // }

        int prev2=nums[0];
        int prev1=Math.max(nums[0],nums[1]);
        int curr;
        for(int i=2;i<n;i++){
            // dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
            curr=Math.max(prev1,nums[i]+prev2);
            prev2=prev1;
            prev1=curr;

        }
        // return dp[n];
        return prev1;

        // int r=nums[n]+houseRob(nums,dp,n-2);
        // int nr=0+houseRob(nums,dp,n-1);

        // return dp[n]=Math.max(r,nr);
       
    }
}
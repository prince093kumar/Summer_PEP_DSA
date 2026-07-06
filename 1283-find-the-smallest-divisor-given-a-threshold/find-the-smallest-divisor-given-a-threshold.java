class Solution {
    public boolean isPossible(int mid,int[] nums,int threshold){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/mid);
        }
        return sum<=threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int max=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int low=1, high=max;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(mid,nums,threshold)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
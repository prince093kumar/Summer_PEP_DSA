class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            firstOccurence(nums,target),lastOccurence(nums,target)
        };
    }

    public int firstOccurence(int[] nums,int target){
        int low=0,high=nums.length-1;
        int i=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                i=mid;
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return i;
    }

    public int lastOccurence(int[] nums,int target){
        int low=0,high=nums.length-1;
        int j=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                j=mid;
                low=mid+1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return j;
    }
}
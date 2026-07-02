class Solution {
    public int singleNumber(int[] nums) {
       
        String res="";
        for(int i=31;i>=0;i--){
             int count=0;
            for(int j=0;j<nums.length;j++){
                if((nums[j] &(1<<i))!=0){
                    count++;
                }
            }
            if(count%3!=0){
                res+="1";
            }
            else{
                res+="0";
            }
        }
     return Integer.parseUnsignedInt(res, 2);
    }
}
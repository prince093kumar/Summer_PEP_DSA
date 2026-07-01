class Solution {
    public int minBitFlips(int start, int goal) {
        int flip=(start^goal);
        int count=0;
        while(flip>0){
            int digit=(flip&1);
            if(digit==1){
                count++;
            }
            flip=flip/2;
        }
        return count;
    }
}
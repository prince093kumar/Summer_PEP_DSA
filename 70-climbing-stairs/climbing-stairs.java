class Solution {
    public int climbStairs(int n) {
        
        // using recursion
        // if(n==0){
        //     return 1;
        // }
        // if(n<0){
        //     return 0;
        // }
        // int stairs=climbStairs(n-1)+climbStairs(n-2);
        // return stairs;

        // using dp with optimization
        int prev2=1;
        int prev1=1;
        int curr;
        for(int i=2;i<=n;i++){
            curr=prev2+prev1;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
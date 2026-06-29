class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        
        // recursion
        // int i=m-1;
        // int j=n-1;
        // int[][] dp=new int[m][n];
        // for(int k=0;k<m;k++){
        //     Arrays.fill(dp[k],-1);
        // }
        // return lcs(text1,text2,i,j,dp);

        // using dp 
        // int[][] dp=new int[m][n];
        // return lcs(text1,text2,m,n,dp);

        // using dp with space optimization
        return lcs(text1,text2,m,n);
    }

    // using dp with recursion 
    // public int lcs(String s,String t,int i,int j,int[][] dp){
    //     if(i<0 || j<0){
    //         return 0;
    //     }

    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }

    //     if(s.charAt(i)==t.charAt(j)){
    //         return dp[i][j]=lcs(s,t,i-1,j-1,dp)+1;
    //     }
    //     else{
    //         return dp[i][j]=0+Math.max(lcs(s,t,i-1,j,dp),lcs(s,t,i,j-1,dp));
    //     }
    // }

    // using dp without recursion 
    // public int lcs(String s,String t,int m,int n,int[][] dp){

    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
                
    //             if(s.charAt(i)==t.charAt(j)){
    //                 int a=0;
    //                 if(i>0 && j>0){
    //                     a=dp[i-1][j-1];
    //                 }
    //                 dp[i][j]=1+a;
    //             }
    //             else{
    //                 int b=0;
    //                 int c=0;
    //                 if(i>0){
    //                     b=dp[i-1][j];
    //                 }
    //                 if(j>0){
    //                     c=dp[i][j-1];
    //                 }
    //                 dp[i][j]=0+Math.max(b,c);
    //             }
    //         }
    //     }
    //     return dp[m-1][n-1];
    // }


    // using dp with space optimization
    public int lcs(String s,String t,int m,int n){
        int[] prev=new int[n];
        
        for(int i=0;i<m;i++){
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                
                if(s.charAt(i)==t.charAt(j)){
                    int a=0;
                    if(i>0 && j>0){
                        a=prev[j-1];
                    }
                    curr[j]=1+a;
                }
                else{
                    int b=0;
                    int c=0;
                    if(i>0){
                        b=prev[j];
                    }
                    if(j>0){
                        c=curr[j-1];
                    }
                    curr[j]=0+Math.max(b,c);
                }
            }
            prev=curr;
        }
        return prev[n-1];
    }
}
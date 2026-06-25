class Solution {
    public int uniquePaths(int m, int n) {
        // return path(0,0,m,n);
        // int[][] dp=new int[m][n];
        // for(int i=0;i<m;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return path(m-1,n-1,m,n,dp);

         // using dp without recursion tc optimization
         int u,l;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                }
                else{
                    u=0;
                    l=0;
                    if(i>0 ){
                      u=dp[i-1][j];
                    }
                  
                    if(j>0){
                        l=dp[i][j-1];
                    }
                    dp[i][j]=u+l;
                
                }
            }
        }
        return dp[m-1][n-1];

    }

    // using recursion 
    // public int path(int i,int j,int m,int n){
    //     if(i==m-1 && j==n-1){
    //         return 1;
    //     }
    //     if(i==m || j==n){
    //         return 0;
    //     }
    //     int d=path(i+1,j,m,n);
    //     int r=path(i,j+1,m,n);
    //     return d+r;
    // }

    // using recursion from last idx
    // public int path(int i,int j,int m,int n){
    //     if(i<0 || j<0 ){
    //         return 0;
    //     }

    //     if(i==0 && j==0){
    //         return 1;
    //     }
    //     int u=path(i-1,j,m,n);
    //     int l=path(i,j-1,m,n);
    //     return u+l;
    // }

    // using dp with recursion
    //  public int path(int i,int j,int m,int n,int[][] dp){
    //     if(i<0 || j<0 ){
    //         return 0;
    //     }

    //     if(i==0 && j==0){
    //         return 1;
    //     }

    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int u=path(i-1,j,m,n,dp);
    //     int l=path(i,j-1,m,n,dp);
    //     return dp[i][j]=u+l;
    // }

   
   
}
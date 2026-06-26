class Solution {
    public int minPathSum(int[][] grid) {
       int i=grid.length;
       int j=grid[0].length;
    //    int[][] dp=new int[i][j];
    //    for(int m=0;m<i;m++){
    //     Arrays.fill(dp[m],-1);
    //    }
    //    return minPath(grid,dp,i-1,j-1);
    // dp without recursion
    //  return minPath(grid,dp,i,j);

    // dp with space optimization 
      return minPath(grid,i,j);
    //using recursion
    //     int i=grid.length-1;
    //    int j=grid[0].length-1;
    //    return minPath(grid,i,j); 
    }

    // using recursion
    // public int minPath(int[][] grid,int i,int j){
    //     if(i==0 && j==0){
    //         return grid[i][j];
    //     }
    //     if(i<0 || j<0){
    //         return Integer.MAX_VALUE;
    //     }
    //     int up=Integer.MAX_VALUE;
    //     int left=Integer.MAX_VALUE;
    //     if(i>0){
    //          up=grid[i][j]+minPath(grid,i-1,j);
    //     }
    //     if(j>0){
    //          left=grid[i][j]+minPath(grid,i,j-1);
    //     }
        
    //     int MinCost=Math.min(up,left);
    //     return MinCost;
    // }

    // public int minPath(int[][] grid,int[][] dp,int i,int j){
    //     if(i==0 && j==0){
    //         return grid[i][j];
    //     }
    //     if(i<0 || j<0){
    //         return Integer.MAX_VALUE;
    //     }
    //     int up=Integer.MAX_VALUE;
    //     int left=Integer.MAX_VALUE;

    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }

    //     if(i>0){
    //          up=grid[i][j]+minPath(grid,dp,i-1,j);
    //     }
    //     if(j>0){
    //          left=grid[i][j]+minPath(grid,dp,i,j-1);
    //     }
        
    //     dp[i][j]=Math.min(up,left);
    //     return dp[i][j];
    // }

//  using dp without recursion
    // public int minPath(int[][] grid,int[][] dp,int m,int n){
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(i==0 && j==0){
    //                 dp[i][j]=grid[i][j];
    //             }
    //             else{
    //                 int up=Integer.MAX_VALUE;
    //                 int left=Integer.MAX_VALUE;
    //                 if(i>0){
    //                     up=grid[i][j]+dp[i-1][j];
    //                 }
    //                 if(j>0){
    //                     left=grid[i][j]+dp[i][j-1];
    //                 }
    //                 dp[i][j]=Math.min(up,left);
    //             }
    //         }
    //     }
    //     return dp[m-1][n-1];
    // }

// using dp with space optimization
    public int minPath(int[][] grid,int m,int n){
        int[] prev=new int[n];
        for(int i=0;i<m;i++){
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    curr[j]=grid[i][j];
                }
                else{
                    int up=Integer.MAX_VALUE;
                    int left=Integer.MAX_VALUE;
                    if(i>0){
                        up=grid[i][j]+prev[j];
                    }
                    if(j>0){
                        left=grid[i][j]+curr[j-1];
                    }
                    curr[j]=Math.min(up,left);
                }
            }
            prev=curr;
        }
        return prev[n-1];
    }
}
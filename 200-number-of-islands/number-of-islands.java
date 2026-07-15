class Solution {
    public int numIslands(char[][] grid) {
        int island=0;
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    bfs(grid,i,j,visited);
                    island++;
                }
            }
        }
        return island;
    }

    public void bfs(char[][] grid,int row,int col,boolean[][]visited){
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        Queue<int[]> que=new LinkedList<>();
        visited[row][col]=true;
        que.offer(new int[]{row,col});
        while(!que.isEmpty()){
            int[] curr=que.poll();
            int r=curr[0];
            int c=curr[1];

            for(int i=0;i<4;i++){
                int nr=r+dx[i];
                int nc=c+dy[i];

                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !visited[nr][nc] && grid[nr][nc]=='1'){
                    que.offer(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }
        }
    }

}
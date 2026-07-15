class Solution {
    public int orangesRotting(int[][] grid) {
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};

        Queue<int[]> que=new LinkedList<>();
        int time=0;
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    que.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        while(!que.isEmpty()){
            boolean rottenThisMin=false;
            int size=que.size();
            for(int i=0;i<size;i++){
                int[] curr=que.poll();
                int r=curr[0];
                int c=curr[1];

                for(int j=0;j<4;j++){
                    int nr=r+dx[j];
                    int nc=c+dy[j];
                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                        fresh--;
                        que.offer(new int[]{nr,nc});
                        grid[nr][nc]=2;
                        rottenThisMin=true;
                    }
                }
            }
            if(rottenThisMin){
                 time++;
            }
        }

        return fresh==0?time:-1;
    }
}
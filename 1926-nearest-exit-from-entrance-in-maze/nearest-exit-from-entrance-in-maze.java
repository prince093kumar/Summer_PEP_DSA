class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int i=entrance[0];
        int j=entrance[1];
        int row=maze.length;
        int col=maze[0].length;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        if(maze[i][j]=='+'){
            return -1;
        }
        Queue<int[]> que=new LinkedList<>();
        que.offer(new int[]{i,j,0});
        while(!que.isEmpty()){
            int[] curr=que.poll();
            int r=curr[0];
            int c=curr[1];
            int move=curr[2];


            if((r==0 || r==row-1 || c==0 || c==col-1) && !(r==i && c==j)){
                return move;
            }

            for(int n=0;n<4;n++){
                int nr=r+dx[n];
                int nc=c+dy[n];
                if(nr>=0 && nr<row && nc>=0 && nc<col  && maze[nr][nc]=='.'){
                    que.offer(new int[]{nr,nc,move+1});
                    maze[nr][nc]='+';
                }
            }
        }
        return -1;
    }
}
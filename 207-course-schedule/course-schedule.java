class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count=0;
        int[] indegree=new int[numCourses];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int src=prerequisites[i][0];
            int dest=prerequisites[i][1];

            adj.get(dest).add(src);
            indegree[src]++;
        }

        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                que.offer(i);
            }
        }
        while(!que.isEmpty()){
            int front=que.poll();
            count++;
            for(int adjNode:adj.get(front)){
                indegree[adjNode]--;
                if(indegree[adjNode]==0){
                    que.offer(adjNode);
                }
            }
        }
        return count==numCourses;
    }
}
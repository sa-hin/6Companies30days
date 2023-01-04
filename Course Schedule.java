class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        List<Integer> graph[]=new ArrayList[numCourses+1];
        for(int i=0;i<=numCourses;i++)
        graph[i]=new ArrayList<>(); 
       int indeg[]=new int[numCourses];
        for(int pre[]:prerequisites){
            graph[pre[0]].add(pre[1]);
            indeg[pre[1]]++;
        }  
        Queue<Integer> q=new LinkedList<>();
        int count=0;
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0) {
                q.add(i);
                count++;
            }
        }
       while(!q.isEmpty()){
           int p=q.poll();

           for(int e:graph[p]){
               indeg[e]--;
               if(indeg[e]==0){
                   q.add(e);
                   count++;
               }
           }
       }
       if(count==numCourses) {
           return true;
       }
       else {
           return false;
       }
    }
}
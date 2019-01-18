class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,List<Integer>> indegree = new HashMap<>();
        int[] outdegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            outdegree[prerequisites[i][0]]+=1;
            if(indegree.containsKey(prerequisites[i][1])){
                List<Integer> list = indegree.get(prerequisites[i][1]);
                list.add(prerequisites[i][0]);
                indegree.put(prerequisites[i][1],list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                indegree.put(prerequisites[i][1],list);
            }
        }
        for(int i=0;i<numCourses;i++){
            if(outdegree[i]==0){
                queue.add(i);
            }
        }
        if(queue.isEmpty()){
            return false;
        }
        int numVisited=0;
        while(queue.size()>0){
            int vertex=queue.peek();
            queue.remove();
            numVisited+=1;
            if(indegree.get(vertex)!=null){
                for(int neighbour : indegree.get(vertex)){
                    outdegree[neighbour]-=1;
                    if(outdegree[neighbour]==0){
                        queue.add(neighbour);
                    }
                }
            }
            
        }
        return numVisited==numCourses;
    }
}

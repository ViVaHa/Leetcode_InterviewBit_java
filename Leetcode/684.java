class Solution {
    public int findParent(int[] parent,int vertex){
        if(vertex!=parent[vertex]){
            parent[vertex]=findParent(parent,parent[vertex]);
        }
        return parent[vertex];
    }
    public int[] findRedundantConnection(int[][] edges) {
        int V=edges.length;
        V=V+1;
        int parent[]=new int[V];
        for(int i=0;i<V;i++){
            parent[i]=i;
        }
        for(int[] edge:edges){
            int v1=edge[0];
            int v2=edge[1];
            int p1=findParent(parent,v1);
            int p2=findParent(parent,v2);
            if(p1==p2){
                return new int[]{v1,v2};
            }
            parent[p1]=p2;
        }
        return new int[2];
    }
}

class Solution {
    public void getFriendsOfFriends(int[][] M, boolean visited[], int vertex){
        visited[vertex]=true;
        for(int i=0;i<M[vertex].length;i++){
            if(M[vertex][i]==1 && !visited[i]){
                getFriendsOfFriends(M,visited,i);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        if(M.length==0){
            return 0;
        }
        boolean visited[] = new boolean[M.length];
        int islands=0;
        for(int i=0;i<M.length;i++){
            boolean firstFriend=true;
            for(int j=0;j<M[0].length;j++){
                if(M[i][j]==1 && !visited[j]){
                    if(firstFriend){
                        islands+=1;
                        firstFriend=false;
                    }
                    if(i==j){
                        visited[j]=true;
                    }else{
                        getFriendsOfFriends(M,visited,j);
                    }  
                }
            }
        }
        return islands;
    }
}

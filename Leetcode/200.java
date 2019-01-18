class Solution {
    public boolean isSafe(boolean[][] visited, int x, int y){
        if(x>=0 && y>=0 && x<visited.length && y<visited[0].length && !visited[x][y]){
            return true;
        }
        return false;
    }
    public void floodFill(char[][] grid,boolean[][] visited, int x, int y){
        visited[x][y]=true;
        int[] x_direc=new int[]{-1,0,0,1};
        int[] y_direc=new int[]{0,-1,1,0};
        for(int d=0;d<4;d++){
            int new_x=x+x_direc[d];
            int new_y=y+y_direc[d];
            if(isSafe(visited,new_x,new_y) && grid[new_x][new_y]=='1'){
                floodFill(grid,visited,new_x,new_y);
            }
        }
    }
    public int numIslands(char[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int islands=0;
        boolean[][] visited = new boolean [grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(isSafe(visited,i,j) && grid[i][j]=='1'){
                    floodFill(grid,visited,i,j);
                    islands+=1;
                }
            }
        }
        return islands;
    }
}

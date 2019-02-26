class Solution {
    int sides=0;
    public boolean isSafe(int x, int y, boolean [][] visited){
        if(x>=0 && x<visited.length && y>=0 && y<visited[0].length &&!visited[x][y]){
            return true;
        }
        return false;
    }
    public void sweep(int[][] grid, int x, int y, boolean[][] visited){
        visited[x][y] = true;
        int[] x_directions = new int[]{0,0,1,-1};
        int[] y_directions = new int[]{1,-1,0,0};
        int neighbours=0;
        for(int i=0;i<4;i++){
            int new_x = x+x_directions[i];
            int new_y = y+y_directions[i];
            if(new_x>=0 && new_x<visited.length && new_y>=0 && new_y<visited[0].length && grid[new_x][new_y]==1){
                if(!visited[new_x][new_y]){
                    sweep(grid,new_x,new_y,visited);
                }
                neighbours+=1;
            }
        }
        if(4-neighbours>0){
            sides+=4-neighbours;
        }
    }
    public int islandPerimeter(int[][] grid) {
        sides=0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    sweep(grid,i,j,visited);
                    //sides+=1;
                }
            }
        }
        return sides;
    }
}

class Solution {
    int maxVal=0;
    public boolean isSafe(int[][] grid, int x, int y, boolean[][] visited){
        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && !visited[x][y] && grid[x][y]==1){
            return true;
        }
        return false;
    }
    public int getSurroundingRegions(int[][] grid, int x, int y, boolean[][] visited){
        visited[x][y]=true;
        int[] xDirections = new int[]{0,0,-1,1};
        int[] yDirections = new int[]{-1,1,0,0};
        int connected=0;
        for(int i=0;i<4;i++){
            int newX = x + xDirections[i];
            int newY = y + yDirections[i];
            if(isSafe(grid,newX,newY,visited)){
                connected+=getSurroundingRegions(grid,newX,newY,visited);
            }
        }
        return connected+1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        maxVal = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 &&!visited[i][j]){
                    maxVal=Math.max(maxVal, getSurroundingRegions(grid,i,j,visited));
                }
            }
        }
        return maxVal;
    }
}

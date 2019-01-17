class Solution {
    static int maxVal;
    public boolean isSafe(int x, int y, boolean visited[][]){
        if(x<visited.length && x>=0 && y>=0 && y<visited[0].length && !visited[x][y]){
            return true;
        }
        return false;
    }
    public int getMaxPath(int[][] matrix, boolean[][] visited,int x, int y,int [][]dp){
        
        if(dp[x][y]!=Integer.MIN_VALUE){
            maxVal=Math.max(dp[x][y],maxVal);
            return dp[x][y];
        }
        visited[x][y]=true;
        int[] x_direc=new int[]{-1,0,0,1};
        int[] y_direc=new int[]{0,-1,1,0};
        int val=0;
        for(int k=0;k<x_direc.length;k++){
            int new_x=x+x_direc[k];
            int new_y=y+y_direc[k];
            if(isSafe(new_x,new_y,visited)){
                if(matrix[x][y]>matrix[new_x][new_y]){
                    val=Math.max(val,getMaxPath(matrix,visited,new_x,new_y,dp));
                }
            }
        }
        dp[x][y]=val+1;
        visited[x][y]=false;
        maxVal=Math.max(dp[x][y],maxVal);
        return dp[x][y];
    }
    public int longestIncreasingPath(int[][] matrix) {
        maxVal=0;
        if(matrix.length==0){
            return maxVal;
        }
        int [][]dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(isSafe(i,j,visited)){
                    int val=getMaxPath(matrix,visited,i,j,dp);
                }
            }
        }
        return maxVal;
    }
}

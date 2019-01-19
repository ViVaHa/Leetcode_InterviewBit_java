class Solution {
    
    public void capture(char[][] board, int x, int y, boolean[][] visited){
        visited[x][y]=true;
        int x_direc[]={-1,0,0,1};
        int y_direc[]={0,1,-1,0};
        for(int d=0;d<x_direc.length;d++){
            int new_x=x+x_direc[d];
            int new_y=y+y_direc[d];
            if(isValid(new_x,new_y,visited) && board[new_x][new_y]=='O' && !visited[new_x][new_y]){
                capture(board,new_x,new_y,visited);
            }
        }
    }
    public boolean isValid(int x, int y, boolean[][] visited){
        if(x>=0 && x<visited.length && y>=0 && y<visited[0].length){
            return true;
        }
        return false;
    }
    public void solve(char[][] board) {
        if(board.length==0){
            return;
        }
        boolean visited[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O')
                capture(board,i,0,visited);
            if(board[i][board[0].length-1]=='O')
                capture(board,i,board[0].length-1,visited);
        }
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O')
                capture(board,0,i,visited);
            if(board[board.length-1][i]=='O')
                capture(board,board.length-1,i,visited);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
}

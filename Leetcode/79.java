class Solution {
    public boolean isSafe(int x, int y, boolean[][] visited){
        if(x>=0 && y>=0 && x<visited.length && y<visited[0].length && visited[x][y]==false){
            return true;
        }
        return false;
    }
    public boolean search(char[][] board, int i, int j, int index, String word, boolean[][] visited ){
        if(index>word.length()){
            return false;
        }
        if(index==word.length()-1){
            if(board[i][j]==word.charAt(index)){
                return true;
            }
            return false;
        }
        // System.out.print(board[i][j]);
        // System.out.println(word.charAt(index));
        
        if(board[i][j]!=word.charAt(index)){
            return false;
        }
        
        int[] x_directions=new int []{-1,0,0,1};
        int[] y_directions=new int []{0,1,-1,0};
        visited[i][j]=true;
        for(int t=0;t<x_directions.length;t++){
            int new_x=i+x_directions[t];
            int new_y=j+y_directions[t];
            if(isSafe(new_x,new_y,visited)){
                if(search(board,new_x,new_y,index+1,word,visited)){
                    return true;
                }   
            }
        }
        visited[i][j]=false;
        index-=1;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        if(board.length==0){
            return false;
        }
        int len=word.length();
        int index=0;
        boolean visited[][]=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0) && !visited[i][j]){
                    if(search(board,i,j,index,word,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

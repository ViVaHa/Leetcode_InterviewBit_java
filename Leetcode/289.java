class Solution {
    public boolean isSafe(int[][] board, int x, int y){
        if(x>=0 && y>=0 && x<board.length && y<board[0].length){
            return true;
        }
        return false;
    }
    public int getSum(int[][] board, int x, int y){
        int x_direc[] = new int[]{-1,-1,1,1,-1,0,0,1};
        int y_direc[] = new int[]{-1,1,-1,1,0,-1,1,0};
        int sum=0;
        for(int d=0;d<8;d++){
            int new_x=x+x_direc[d];
            int new_y=y+y_direc[d];
            if(isSafe(board,new_x,new_y)){
                sum+=board[new_x][new_y];
            }
        }
        return sum;
    }
    public void gameOfLife(int[][] board) {
        List<List<Integer>>changes = new ArrayList<>();
        if(board.length==0){
            return;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int sum = getSum(board,i,j);
                if(board[i][j]==1){
                    if(sum<2 || sum>3){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        changes.add(temp);
                    }
                }else{
                    if(sum==3){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        changes.add(temp);
                    }
                }
            }
        }
        for(List<Integer> change : changes ){
            int row=change.get(0);
            int col=change.get(1);
            board[row][col] = 1 - board[row][col];
        }
    }
}

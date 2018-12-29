class Solution {
    public int[][] generateMatrix(int n) {
        if(n==0){
            return new int[0][0];
        }
        int output[][]=new int[n][n];
        int startRow=0;
        int startCol=0;
        int endRow=n;
        int endCol=n;
        int val=1;
        while(startRow<endRow && startCol<endCol){
            for(int j=startCol;j<endCol;j++){
                output[startRow][j]=val;
                val+=1;
            }
            startRow+=1;
            for(int i=startRow;i<endRow;i++){
                output[i][endRow-1]=val;
                val+=1;
            }
            endCol-=1;
            for(int j=endCol-1;j>=startCol;j--){
                output[endRow-1][j]=val;
                val+=1;
            }
            endRow-=1;
            for(int i=endRow-1;i>=startRow;i--){
                output[i][startCol]=val;
                val+=1;
            }
            startCol+=1;
        }
        return output;
    }
}

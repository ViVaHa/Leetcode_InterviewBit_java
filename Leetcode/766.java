class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length==0){
            return true;
        }
        int startRow=matrix.length-1;
        int startCol=0;
        int endCol=matrix[0].length-1;
        int endRow=matrix.length-1;
        while(startRow>=0 && startCol<=endCol){
            int val=matrix[startRow][startCol];
            int tempRow=startRow;
            int tempCol=startCol;
            while(startRow>=0 && startCol>=0){
                if(matrix[startRow][startCol]!=val){
                    return false;
                }
                startRow-=1;
                startCol-=1;
            }
            if(tempCol==endCol){
                startRow=tempRow-1;
                startCol=tempCol;
            }else{
                startRow=tempRow;
                startCol=tempCol+1;
            }
        }
        return true;
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> retVal=new ArrayList<>();
        if(matrix.length==0){
            return retVal;
        }
        int rows=matrix.length;
        int cols=matrix[0].length;
        int startRows=0;
        int startCols=0;
        int endRows=rows;
        int endCols=cols;
        int i,j;
        while(startCols<endCols && startRows<endRows){
            for(j=startCols;j<endCols;j++){
                retVal.add(matrix[startRows][j]);
            }
            startRows+=1;
            for(i=startRows;i<endRows;i++){
                retVal.add(matrix[i][endCols-1]);
                
            }
            endCols-=1;
            if(startRows>=endRows){
                break;
            }
            for(j=endCols-1;j>=startCols;j--){
                retVal.add(matrix[endRows-1][j]);
            }
            endRows-=1;
            if(startCols>=endCols){
                break;
            }
            for(i=endRows-1;i>=startRows;i--){
                retVal.add(matrix[i][startCols]);
            }
            startCols+=1;
        }
        return retVal;
    }
}

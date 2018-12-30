class Solution {
    public boolean binarySearch(int[][] matrix, int row ,int target){
        //System.out.println(row);
        int inspectRow[]=new int[matrix[0].length];
        inspectRow=matrix[row];
        int start=0;
        int end = inspectRow.length-1;
        while(start<=end){
            if(start==end){
                return inspectRow[start]==target;
            }
            int mid=(start+end)/2;
            if(target==inspectRow[mid]){
                return true;
            }
            else if(inspectRow[mid]<target){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int startC=0;
        int endC=matrix[0].length-1;
        int indexC=matrix[0].length-1;
        int indexR=matrix.length-1;
        while(indexR>=0){
            if(matrix[indexR][indexC]==target){
                return true;
            }else if(target<matrix[indexR][startC]){
                indexR-=1;
            }else{
                return binarySearch(matrix,indexR,target);
            }
        }
        return false;
    }
}

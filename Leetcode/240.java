class Solution {
    public boolean searchMatrix(int[][] nums, int target) {
        if(nums.length==0){
            return false;
        }
        int startRow=0;
        int startCol=nums[0].length-1;
        int endCol = 0;
        int endRow = nums.length;
        while(startRow<endRow && startCol>=endCol){
            if(nums[startRow][startCol]==target){
                return true;
            }else if(nums[startRow][startCol]>target){
                startCol-=1;
            }else{
                startRow+=1;
            }
        }
        return false;
    }
}

class NumArray {
    int continousSum[];
    public NumArray(int[] nums) {
        continousSum = new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            continousSum[i]=sum;
        }
    }
    
    public int sumRange(int i, int j) {
        if(i==0){
            return continousSum[j];
        }else{
            return continousSum[j]-continousSum[i-1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

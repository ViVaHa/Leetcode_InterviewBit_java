class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min_2=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        for(int n:nums){
            if(n<=min){
                min=n;
            }else if(n<=min_2){
                min_2=n;
            }else{
                return true;
            }
        }
        return false;
    }
}

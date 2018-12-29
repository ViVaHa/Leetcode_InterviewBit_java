class Solution {
    public int maxArea(int[] height) {
        if(height.length==0){
            return 0;
        }
        int start=0;
        int end=height.length-1;
        int maxArea=0;
        while(start<end){
            maxArea=Math.max(maxArea,Math.min(height[start],height[end])*(end-start));
            if(height[start]<height[end]){
                start+=1;
            }else{
                end-=1;
            }
        }
        return maxArea;
    }
}

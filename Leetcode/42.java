class Solution {
    public int trap(int[] height) {
        if(height.length==0){
            return 0;
        }
        int lefts[]=new int[height.length];
        int rights[]=new int[height.length];
        lefts[0]=height[0];
        for(int i=1;i<lefts.length;i++){
            lefts[i]=Math.max(lefts[i-1],height[i]);
        }
        rights[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rights[i]=Math.max(rights[i+1],height[i]);
        }
        int capacity=0;
        for(int i=0;i<height.length;i++){
            capacity+=Math.min(lefts[i],rights[i])-height[i];
        }
        return capacity;
    }
}

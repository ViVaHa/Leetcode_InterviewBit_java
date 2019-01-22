class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int maxNums[]=new int[nums.length-k+1];
        Deque<Integer> queue = new ArrayDeque<>();
        if(nums.length==0){
            return new int[0];
        }
        for(int i=0;i<k;i++){
            if(queue.isEmpty()){
                queue.add(i);
            }else{
                while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i]){
                    queue.pollLast();
                }
                queue.add(i);
            }
        }
        
        maxNums[0]=nums[queue.peek()];
        for(int i=k;i<nums.length;i++){
            while(!queue.isEmpty() && queue.peek()<i-k+1){
                queue.remove();
            }
            if(queue.isEmpty()){
                queue.add(i);
            }else{
                while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i]){
                    queue.pollLast();
                }
                queue.add(i);
            }
            maxNums[i-k+1]=nums[queue.peek()];
        }
        return maxNums;
    }
}

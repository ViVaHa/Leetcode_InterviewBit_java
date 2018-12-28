class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>>retVal=new HashSet<>();
        int i=0;
        while(i<nums.length){
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                if(nums[i]+nums[start]+nums[end]==0){
                    retVal.add(Arrays.asList(nums[start], nums[i], nums[end]));
                    while(start<end && nums[start]==nums[start+1]){
                        start+=1;
                    }
                    while(start<end && nums[end]==nums[end-1]){
                        end-=1;
                    }
                    start+=1;
                    end-=1;
                }
                else if(nums[i]+nums[start]+nums[end]<0){
                    start+=1;
                }
                else{
                    end-=1;
                }
            }
            i+=1;
        }
        List<List<Integer>> list= new ArrayList<>();
        list.addAll(retVal);
        return list;
    }
}

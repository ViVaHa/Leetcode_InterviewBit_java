class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set=new HashSet<>();
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        int i=0;
        int j=i+1;
        while(i<nums.length){
            j=i+1;
            while(j<nums.length){
                int start=j+1;
                int end=nums.length-1;
                while(start<end){
                    if(nums[start]+nums[end]+nums[i]+nums[j]==target){
                        set.add(Arrays.asList(nums[start],nums[end],nums[i],nums[j]));
                        while(start<end && nums[start]==nums[start+1]){
                            start+=1;
                        }
                        while(start<end && nums[end]==nums[end-1]){
                            end-=1;
                        }
                        start+=1;
                        end-=1;                                                           
                    }else if(nums[start]+nums[end]+nums[i]+nums[j]>target){
                        end-=1;
                    }
                    else{
                        start+=1;
                    }                                                             
                }
                j+=1;                                                                  
            }
            i+=1;                                                                        
        }
        list.addAll(set);
        return list;                                                                           
    }
}

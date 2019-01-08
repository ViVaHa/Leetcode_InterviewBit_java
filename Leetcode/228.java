class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start=0;
        int end=0;
        List<String> ranges = new ArrayList<>();
        while(start<nums.length && end<nums.length){
            while(end+1<nums.length && nums[end]==nums[end+1]-1){
                end+=1;
            }
            if(start==end){
                ranges.add(String.valueOf(nums[start]));
                end=end+1;
                start=end;
            }else{
                StringBuilder temp=new StringBuilder("");
                temp.append(String.valueOf(nums[start]));
                temp.append("->");
                temp.append(String.valueOf(nums[end]));
                ranges.add(temp.toString());
                start=end+1;
                end=end+1;
            }
        }
        return ranges;
    }
}

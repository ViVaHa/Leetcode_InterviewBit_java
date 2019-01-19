class Solution {
    public String largestNumber(int[] nums) {
        List<String> numbers = new ArrayList<>();
        int maxNum=0;
        Map<String, List<String>> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numbers.add(String.valueOf(nums[i]));
            maxNum=Math.max(maxNum,nums[i]);
        }
        int maxLen = (String.valueOf(maxNum)).length()+1;
        for(int i=0;i<numbers.size();i++){
            String val = numbers.get(i);
            StringBuilder number = new StringBuilder(val);
            for(int len=0;len<maxLen;len++){
                number.append(val);
            }
            String sub=number.substring(0,maxLen);
            numbers.set(i,sub);
            List<String> temp;
            if(hashMap.get(sub)==null){
                temp = new ArrayList<>();
            }else{
                temp=hashMap.get(sub);  
            }
            temp.add(val);
            hashMap.put(sub,temp);
            
        }
        Collections.sort(numbers,Collections.reverseOrder());
        StringBuilder ans = new StringBuilder(""); 
        for(String n:numbers){
            List<String> temp = hashMap.get(n);
            hashMap.put(n,null);
            if(temp!=null){
                for(String s:temp){
                    ans.append(s);
                }
            }
            
        }
        String ret = ans.toString();
        if(ans.charAt(0)=='0'){
            return "0";
        }
        return ans.toString();
    }
}

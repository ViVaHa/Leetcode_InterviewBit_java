class Solution {
    public boolean isHappy(int n) {
        int curr=n;
        Map<Integer,Integer> map = new HashMap<>();
        while(curr!=1){
            int temp=curr;
            curr=0;
            while(temp!=0){
                int rem=temp%10;
                curr+=rem*rem;
                temp/=10;
            }
            if(map.get(curr)!=null){
                return false;
            }else{
                map.put(curr,1);
            }
        }
        return true;
    }
}

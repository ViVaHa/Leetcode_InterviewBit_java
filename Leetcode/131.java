class Solution {
    public boolean isPalindrome(String s, int start, int end){
        if(start==end){
            return true;
        }
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start+=1;
            end-=1;
        }
        return true;
    }
    public void generatePartitions(String s, int start, int end, List<List<String>> res, List<String> temp){
        if(start>end){
            List<String> toInsert = new ArrayList<>(temp); 
            res.add(toInsert);
            return;
        }    
        for(int i=start;i<=end;i++){
            if(isPalindrome(s,start,i)){
                temp.add(s.substring(start,i+1));
                generatePartitions(s,i+1,end,res,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {    
        List<List<String>> res = new ArrayList<>();
        if(s.length()==0){
            return res;
        }
        List<String> temp = new ArrayList<>();
        generatePartitions(s,0,s.length()-1,res,temp);
        return res;
    }
}

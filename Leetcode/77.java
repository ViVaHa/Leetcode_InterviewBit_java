class Solution {
    public void generate(List<List<Integer>> res, List<Integer>temp, int start, int end, int k){
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<=end;i++){
            temp.add(i);
            generate(res,temp,i+1,end,k);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        if(n==0 || k==0){
            return res;
        }
        generate(res,temp,1,n,k);
        return res;
    }
}

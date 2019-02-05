class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if(n==0){
            res.add(0);
            return res;
        }
        res.add(0);
        res.add(1);
        if(n==1){
            return res;
        }
        int steps=2;
        for(int times=2;times<=n;times++){
            for(int j=res.size()-1;j>=0;j--){
                int val=res.get(j);
                res.add(val+steps);
            }
            steps*=2;
        }
        return res;
    }
}

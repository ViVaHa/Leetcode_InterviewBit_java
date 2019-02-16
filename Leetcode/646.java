class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)-> a[1]-b[1]);
        int lastVal=Integer.MIN_VALUE;
        int cnt=0;
        for(int i=0;i<pairs.length;i++){
            if(lastVal<pairs[i][0]){
                cnt+=1;
                lastVal = Math.max(lastVal,pairs[i][1]);
            }
        }
        return cnt;
    }
}

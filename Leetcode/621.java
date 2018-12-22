class Solution {
    public int leastInterval(char[] tasks, int n) {
       int[] vals=new int[26];
        for(int i=0;i<tasks.length;i++){
            vals[tasks[i]-'A']+=1;
        }
        Arrays.sort(vals);
        int max=vals[25];
        int i;
        for(i=24;i>=0;i--){
            if(vals[i]!=max){
                break;
            }
        }
        int maxChars=25-i;
        return Math.max((max-1)*(n+1)+maxChars,tasks.length);
    }
}

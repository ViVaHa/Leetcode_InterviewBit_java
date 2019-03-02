class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] first = new int[26];
        int[] last = new int[26];
        for(int i=0;i<26;i++){
            first[i] = -1;
            last[i]=-1;
        }
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(first[c-'a']==-1){
                first[c-'a']=i;
                last[c-'a']=i;
            }else{
                last[c-'a']=i;
            }
        }
        Arrays.sort(first);
        Arrays.sort(last);
        int i;
        for(i=0;i<26;i++){
            if(first[i]!=-1){
                break;
            }
        }
        int j=i+1;
        int end=last[i];
        List<Integer> res = new ArrayList<>();
        while(j<26 && i<26){
            if(first[j]<=end){
                end=Math.max(last[j],end);
                
            }else{
                res.add(end-(first[i])+1);
                i=j;
                end=last[i];
            }
            j+=1;
        }
        res.add(end-(first[i])+1);
        return res;
    }
}

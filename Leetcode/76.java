class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int counter = map.size();
        int end=0;
        int start=0;
        int minLength = Integer.MAX_VALUE;
        int resStart = -1;
        int resEnd = -1;
        while(end<s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    counter-=1;
                }
            }
            while(counter==0){
                if(end-start+1<minLength){
                    minLength=end-start+1;
                    resStart = start;
                    resEnd = end;
                }
                char st = s.charAt(start);
                if(map.containsKey(st)){
                    map.put(st,map.get(st)+1);
                    if(map.get(st)==1){
                        counter+=1;
                    }
                }
                start+=1;
            }
            end+=1;
        }
        if(counter==0 && end-start<minLength){
            resStart = start;
            resEnd = end;
        }
        if(resStart!=-1){
            return s.substring(resStart,resEnd+1);
        }else{
            return "";
        }
    }
}

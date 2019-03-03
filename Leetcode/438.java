class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int start=0;
        int end=0;
        int len = p.length();
        int counter = map.size();
        List<Integer> res = new ArrayList<>();
        while(end<s.length()){
            
            char c = s.charAt(end);
            if(map.get(c)!=null)
                map.put(c,map.get(c)-1);
            if(map.get(c)!=null && map.get(c)==0){
                counter-=1;
            }
            //System.out.println(c);
            while(counter==0){
                if(end-start+1==len){
                    res.add(start);
                }
                if(map.get(s.charAt(start))!=null){
                    map.put(s.charAt(start),map.get(s.charAt(start))+1);
                    if(map.get(s.charAt(start))>0){
                        counter+=1;
                    }
                }
                start+=1;
            }
            end+=1;
        }
        if(counter==0 && end-start-1==map.size()){
            res.add(start);
        }
        return res;
    }
}

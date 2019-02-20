class Solution {
    public String frequencySort(String s) {
        if(s==null || s==""){
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character> buckets [] = new List[s.length()+1];
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            //System.out.println(entry.getValue() + " " +entry.getKey());
            if(buckets[entry.getValue()]==null){
                buckets[entry.getValue()] = new ArrayList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }
        StringBuilder builder = new StringBuilder();
        for(int i=buckets.length-1;i>=0;i--){
            if(buckets[i]!=null){
                for(Character c : buckets[i] ){
                    for(int j=0;j<map.get(c);j++){
                        builder.append(c);
                    }
                    
                }   
            }
            
        }
        return builder.toString();
    }
}

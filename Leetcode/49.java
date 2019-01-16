class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> retVal= new ArrayList<>();
        for(String str:strs){
            char temp[]=str.toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);
            if(map.containsKey(sorted)){
                List<String> list = map.get(sorted);
                list.add(str);
                map.put(sorted,list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted,list);
            }
        }
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            retVal.add(entry.getValue());
        }
        return retVal;
    }
}

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        int largestLength=0;
        List<String> strings = new ArrayList<>();
        for(Integer x : A){
            int len=String.valueOf(x).length();
            strings.add(String.valueOf(x));
            if(len>largestLength){
                largestLength=len;
            }
        }
        largestLength+=1;
        Map<String,List<String>> map = new HashMap<>();
        StringBuilder temp = new StringBuilder("");
        List<String> finalStrings = new ArrayList<>();
        for(String s : strings){
            temp = new StringBuilder("");
            int len=s.length();
            temp.append(s);
            for(int i=0;i<largestLength;i++){
                temp.append(s);
            }
            if(map.get(temp.toString())==null){
                List<String>list = new ArrayList<>();
                list.add(s);
                map.put(temp.toString(),list);
            }else{
                List<String>list = map.get(temp.toString());
                list.add(s);
                map.put(temp.toString(),list);
            }
            finalStrings.add(temp.toString());
        }
        Set<String>set=new HashSet<>(finalStrings);
        finalStrings=new ArrayList<>(set);
        Collections.sort(finalStrings,Collections.reverseOrder());
        temp=new StringBuilder("");
        for(String s: map.get(finalStrings.get(0))){
            if(s.equals("0")){
                return "0";
            }
        }
        for(String s:finalStrings){
            for(String k:map.get(s)){
                temp.append(k);
            }
        }
        return temp.toString();
    }
}


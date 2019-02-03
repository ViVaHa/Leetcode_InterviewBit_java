class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        HashMap<String,Character> map = new HashMap<>();
        HashMap<Character,String> reverseMap = new HashMap<>();
        if(words.length!=pattern.length()){
            return false;
        }
        int i=0;
        for(String word:words){
            if(map.get(word)==null){
                map.put(word,pattern.charAt(i));
            }else{
                if(!map.get(word).equals(pattern.charAt(i))){
                    return false;
                }
            }
            
            if(reverseMap.get(pattern.charAt(i))==null){
                reverseMap.put(pattern.charAt(i),word);
            }else{
                if(!reverseMap.get(pattern.charAt(i)).equals(word)){
                    return false;
                }
            }
            i+=1;
        }
        return true;
    }
}

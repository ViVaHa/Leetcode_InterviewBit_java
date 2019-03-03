class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for(String bannedString : banned){
            set.add(bannedString);
        }
        Map<String, Integer> wordsCount = new HashMap<>();
        StringBuilder currentWord = new StringBuilder("");
        int maxVal = 0;
        String answer ="";
        for(int i=0;i<paragraph.length();i++){
            if(Character.isLetter(paragraph.charAt(i))){
                currentWord.append(Character.toLowerCase((paragraph.charAt(i))));
            }else{
                if(currentWord.length()>0){
                    wordsCount.put(currentWord.toString(), wordsCount.getOrDefault(currentWord.toString(),0)+1);
                    if(!set.contains(currentWord.toString()) && wordsCount.get(currentWord.toString())>maxVal){
                        maxVal = wordsCount.get(currentWord.toString());
                        answer = currentWord.toString();
                    }
                    currentWord = new StringBuilder("");
                }
            }
        }
        if(currentWord.length()>0){
                    wordsCount.put(currentWord.toString(), wordsCount.getOrDefault(currentWord.toString(),0)+1);
                    if(!set.contains(currentWord.toString()) && wordsCount.get(currentWord.toString())>maxVal){
                        maxVal = wordsCount.get(currentWord.toString());
                        answer = currentWord.toString();
                    }
                    currentWord = new StringBuilder("");
                }
        return answer;
    }
}

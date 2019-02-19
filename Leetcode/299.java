class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int bulls=0;
        for(int i=0;i<guess.length();i++){
            if(guess.charAt(i)==secret.charAt(i)){
                bulls+=1;
            }else{
                map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i),0)+1);
            }
        }
        int cows=0;
        
        for(int i=0;i<guess.length();i++){
            if(map.get(guess.charAt(i))!=null && map.get(guess.charAt(i))>0){
                if(guess.charAt(i)!=secret.charAt(i)){
                    cows+=1;
                    map.put(guess.charAt(i),map.getOrDefault(guess.charAt(i),0)-1);
                }
            }
        }
        StringBuilder builder = new StringBuilder("");
        builder.append(String.valueOf(bulls));
        builder.append("A");
        builder.append(String.valueOf(cows));
        builder.append("B");
        return builder.toString();
    }
}

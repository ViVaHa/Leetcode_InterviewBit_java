class Solution {
    public boolean isVowel(char c){
        if(c=='a'|| c=='e' || c=='i' || c=='o' || c=='u'|| c=='A'|| c=='E' || c=='I' || c=='O' || c=='U'){
            return true;
        }
        return false;
    }
    public String reverseVowels(String s) {
        StringBuilder temp = new StringBuilder(s);
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            while(start<end && !isVowel(s.charAt(start))){
                start+=1;
            }
            while(start<end && !isVowel(s.charAt(end))){
                end-=1;
            }
            if(start>end){
                break;
            }
            char c = temp.charAt(start);
            temp.setCharAt(start,temp.charAt(end));
            temp.setCharAt(end,c);
            start+=1;
            end-=1;
        }
        return temp.toString();
    }
}

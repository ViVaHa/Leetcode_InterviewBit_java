class Solution {
    public void generateCombinations(String digits, int index, String[] letters, StringBuilder temp, List<String> res){
        if(index>digits.length()){
            return;
        }
        if(index==digits.length()){
            res.add(temp.toString());
            return;
        }
        int number=Character.getNumericValue(digits.charAt(index));
        for(char c : letters[number-1].toCharArray()){
            temp.append(c);
            generateCombinations(digits,index+1,letters,temp,res);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        
        String [] letters = new String []{"*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        generateCombinations(digits,0,letters,new StringBuilder(""),res);
        return res;
    }
}

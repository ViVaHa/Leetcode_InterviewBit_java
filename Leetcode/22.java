class Solution {
    public void generate(int n, int openBrackets, int closeBrackets, StringBuilder temp, List<String> result){
        if(openBrackets>n || closeBrackets>n || openBrackets<closeBrackets){
            return;
        }
        if(openBrackets==n && closeBrackets==n){
            result.add(temp.toString());
            return;
        }
        generate(n,openBrackets+1,closeBrackets,temp.append("("),result);
        temp.deleteCharAt(temp.length()-1);
        generate(n,openBrackets,closeBrackets+1,temp.append(")"),result);
        temp.deleteCharAt(temp.length()-1);
    }
    public List<String> generateParenthesis(int n) {
        int openBrackets=0;
        int closeBrackets=0;
        if(n==0){
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<>();
        generate(n,openBrackets,closeBrackets,new StringBuilder(""),result);
        return result;
    }
}

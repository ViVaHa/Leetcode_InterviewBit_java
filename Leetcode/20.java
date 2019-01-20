class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(c==')'){
                    if(top!='('){
                        return false;
                    }
                }
                if(c=='}'){
                    if(top!='{'){
                        return false;
                    }
                }
                if(c==']'){
                    if(top!='['){
                        return false;
                    }
                }
            }
            i+=1;
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}

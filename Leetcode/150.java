class Solution {
    boolean isOperator(String val){
        if("+".equals(val) || "-".equals(val) || "*".equals(val) || "/".equals(val)){
            return true;
        }
        return false;
    }
    public int evalRPN(String[] tokens) {
        if(tokens.length==0){
            return 0;
        }
        int val=0;
        Stack<Integer> stack = new Stack<>();
        stack.add(Integer.parseInt(tokens[0]));
        int index=1;
        while(!stack.isEmpty() && index<tokens.length){
            if(isOperator(tokens[index])){
                int val1=stack.pop();
                int val2=stack.pop();
                if("+".equals(tokens[index])){
                    stack.add(val1+val2);
                }else if("-".equals(tokens[index])){
                    stack.add(val2-val1);
                }else if("*".equals(tokens[index])){
                    stack.add(val1*val2);
                }else{
                    stack.add(val2/val1);
                }
            }else{
                stack.add(Integer.parseInt(tokens[index]));
            }
            index+=1;
        }
        return stack.pop();
    }
}

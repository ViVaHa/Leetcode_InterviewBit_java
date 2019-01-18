class Solution {
    public int getPrecedence(char operator){
        if(operator=='+' || operator=='-'){
            return 1;
        }else{
            return 2;
        }
    }
    public int calculate(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int index=0;
        while(index<s.length()){
            if(index<s.length()){
                char character = s.charAt(index); 
                if(character==' '){
                    index+=1;
                }else if(Character.isDigit(character)){
                    int val=0;
                    while(index<s.length() && Character.isDigit(s.charAt(index))){
                        val=val*10+Character.getNumericValue(s.charAt(index));
                        index+=1;
                    }
                    numberStack.add(val);
                }else{
                    if(operatorStack.isEmpty()){
                        operatorStack.add(s.charAt(index));
                    }else if(getPrecedence(s.charAt(index))>getPrecedence(operatorStack.peek())){
                        operatorStack.add(s.charAt(index));
                    }else{
                        while(!operatorStack.isEmpty() && getPrecedence(s.charAt(index))<=getPrecedence(operatorStack.peek())){
                            char op=operatorStack.pop();
                            int val2=numberStack.pop();
                            int val1=numberStack.pop();
                            if(op=='+'){
                                numberStack.add(val1+val2);
                            }else if(op=='-'){
                                numberStack.add(val1-val2);
                            }else if(op=='*'){
                                numberStack.add(val1*val2);
                            }else{
                                System.out.printf("%d,%d",val1,val2);
                                System.out.println();
                                numberStack.add(val1/val2);
                            }
                        }
                        operatorStack.add(s.charAt(index));
                    }
                    index+=1;
                }
            }
        }
        while(!operatorStack.isEmpty()){
            char op=operatorStack.pop();
            int val2=numberStack.pop();
            int val1=numberStack.pop();
            if(op=='+'){
                numberStack.add(val1+val2);
            }else if(op=='-'){
                numberStack.add(val1-val2);
            }else if(op=='*'){
                numberStack.add(val1*val2);
            }else{
                numberStack.add(val1/val2);
            }
        }
        return numberStack.pop();
    }
}

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String str : ops){
            char c = str.charAt(0); 
            if(c=='C'){
                stack.pop();
            }else if(c=='D'){
                int top = stack.peek();
                stack.push(top*2);
            }else if(c=='+'){
                int val1=stack.pop();
                int val2=stack.pop();
                stack.push(val2);
                stack.push(val1);
                stack.push(val1+val2);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            
            sum+=stack.pop();
        }
        return sum;
    }
}

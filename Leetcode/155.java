class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        mainStack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else{
            minStack.push(Math.min(minStack.peek(),x));
        }
        
    }
    
    public void pop() {
        mainStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {
    
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    
    public MinStack(){
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty() || x<=stack2.peek()){
            stack2.push(x);
        }
    }

    public void pop() {
        if(stack1.isEmpty()){
            return;
        }else{
            int ret = stack1.pop();
            if(ret == stack2.peek())
                stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}

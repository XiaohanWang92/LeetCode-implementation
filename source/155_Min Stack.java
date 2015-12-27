class MinStack {
    private Stack<Integer> s;
    private Stack<Integer> minS;//consecutive sequence in increasing order
    MinStack(){
        s=new Stack<Integer>();
        minS=new Stack<Integer>();
    }
    public void push(int x) {
        s.push(x);
        if(minS.size()!=0){
            if(x<=minS.peek())
                minS.push(x);//*equal
        }
        else{
            minS.push(x);
        }
    }

    public void pop() {
        int check=s.pop();
        if(minS.size()!=0){//not while, only check once!
            if(minS.peek()==check)
                minS.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minS.peek();
    }
}
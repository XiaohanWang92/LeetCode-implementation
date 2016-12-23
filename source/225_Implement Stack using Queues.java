class MyStack {

    // Push element x onto stack.
    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<Integer>();
    }

    public void push(int x) {
        q.add(x);
        int i = 0;
        int size = q.size();
        while(i < size - 1) {
            int t = q.remove();
            q.add(t);
            i++;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(q.size() == 0){
            return true;
        } else {
            return false;
        }
    }
}

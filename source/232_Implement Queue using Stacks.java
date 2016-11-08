class MyQueue {

    // Push element x to the back of queue, s1 for push, s2 for pop.
    private Deque<Integer> s1;
    private Deque<Integer> s2;

    public MyQueue() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from queue.
    public void pop() {
        if(s1.isEmpty() && s2.isEmpty())    return;
        if(s2.size() == 0) {
            int num = s1.size();
            for(int i = 1; i <= num; i++) {
                s2.push(s1.pop());
            }
            s2.pop();
        } else {
            s2.pop();
        }
    }

    // Get the first element.
    public int peek() {
        if(s2.size() == 0) {
            int num = s1.size();
            for(int i = 1; i <= num; i++) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    // Return whether queues are empty.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

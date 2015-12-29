class MyQueue {
    Stack<Integer> s1=new Stack<>();//for tail half part
    Stack<Integer> s2=new Stack<>();//for head half part
    public MyQueue(){
        s1=new Stack<>();
        s2=new Stack<>();
    }
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(s1.empty()&&s2.empty())  return;
	//base on question, above condition statement doesn't need
        if(s2.isEmpty()){
            while(s1.size()!=0){
                s2.push(s1.pop());
            }
        }
        s2.pop();

    }

    // Get the front element.
    public int peek() {
        if(s2.isEmpty()){
            while(s1.size()!=0){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.empty()&&s2.empty();
    }
}
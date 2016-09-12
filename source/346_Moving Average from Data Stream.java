public class MovingAverage {

    private int size;
    private int currentSum;
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        currentSum = 0;
        queue = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        int currentSize = this.size;
        if(queue.size() < size) {
            queue.add(val);
            currentSum += val;
            currentSize = queue.size();
        } else {
            int dequeuedNumber = queue.poll();
            currentSum -= dequeuedNumber;
            queue.add(val);
            currentSum += val;
        }
        return (double)currentSum / currentSize;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

public class MedianFinder {
    
    PriorityQueue<Integer> leftHalfMax = new PriorityQueue<>(100, Collections.reverseOrder());
    PriorityQueue<Integer> rightHalfMin = new PriorityQueue<>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        
        // put element in left max part
        leftHalfMax.offer(num);
        
        // let largest element in left max be dequeued
        rightHalfMin.offer(leftHalfMax.poll());
        
        // balance two part of the data stream
        if(leftHalfMax.size() < rightHalfMin.size()) {
            leftHalfMax.offer(rightHalfMin.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(leftHalfMax.size() == rightHalfMin.size() + 1)   return leftHalfMax.peek();
        else    return (leftHalfMax.peek() + rightHalfMin.peek()) / 2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();

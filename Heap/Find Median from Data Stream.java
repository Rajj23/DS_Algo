// ************************************************************************** JAVA *****************************************************************************

// T.C: O(logN)
// S.C: O(N)
class MedianFinder {
    PriorityQueue<Integer> left_max_heap;
    PriorityQueue<Integer> right_min_heap;
    public MedianFinder() {
        left_max_heap = new 
    PriorityQueue<>((a,b)->b-a);
        right_min_heap = new 
    PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left_max_heap.isEmpty() || num < left_max_heap.peek()){
            left_max_heap.offer(num);
        }
        else{
            right_min_heap.offer(num);
        }

        if(Math.abs(left_max_heap.size() - right_min_heap.size()) > 1){
            right_min_heap.offer(left_max_heap.poll());
        }
        else if(left_max_heap.size() < right_min_heap.size()){
            left_max_heap.offer(right_min_heap.poll());
        }
    }
    
    public double findMedian() {
        if(left_max_heap.size() == right_min_heap.size()){
            double mean = (left_max_heap.peek() + right_min_heap.peek())/2.0;
            return mean;
        }
        else{
            return left_max_heap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// ************************************************************************** C++ *****************************************************************************

// T.C: O(logN)
// S.C: O(N)
class MedianFinder {
public:
    priority_queue<int> left_max_heap;
    priority_queue<int, vector<int>, greater<int>> right_min_heap;
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        if(left_max_heap.empty() || num < left_max_heap.top()){
            left_max_heap.push(num);
        }
        else{
            right_min_heap.push(num);
        }

        if(abs((int)left_max_heap.size() - (int)right_min_heap.size()) > 1){
            right_min_heap.push(left_max_heap.top());
            left_max_heap.pop();
        }
        else if(left_max_heap.size() < right_min_heap.size()){
            left_max_heap.push(right_min_heap.top());
            right_min_heap.pop();
        }
    }
    
    double findMedian() {
        if(left_max_heap.size()==right_min_heap.size()){
            return (left_max_heap.top() + right_min_heap.top())/2.0;
        }
        return left_max_heap.top();
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */
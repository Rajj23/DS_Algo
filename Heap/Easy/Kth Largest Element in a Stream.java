// **************************************************************************** JAVA *************************************************************************

// T.C: O(nlogK)
// S.C: O(K)
class KthLargest {

    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;

        for(int num:nums){
            pq.add(num);

            if(pq.size()>k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);

        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}


// **************************************************************************** JAVA *************************************************************************

// T.C: O(nlogK)
// S.C: O(K)
class KthLargest {
public:
    priority_queue<int,vector<int>,greater<>> pq;
    int K;
    KthLargest(int k, vector<int>& nums) {
        K = k;

        for(int &num : nums){
            pq.push(num);

            if(pq.size()>K){
                pq.pop();
            }
        }
    }
    
    int add(int val) {
        pq.push(val);

        if(pq.size()>K){
            pq.pop();
        }

        return pq.top();
    }
};
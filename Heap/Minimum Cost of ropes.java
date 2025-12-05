// *********************************************************** JAVA ***********************************************************************

// T.C: O(N+logN)
// S.C: O(N)
class Solution {
    public static int minCost(int[] arr) {
        // code here
        int cost = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int it:arr){
            pq.add(it);
        }
        
        while(!pq.isEmpty()){
            int first = pq.poll();
            if(pq.isEmpty()){
                break;
            }
            int second = pq.poll();
            
            int sum = first + second;
            cost += sum;
            pq.add(sum);
        }
        
        return cost;
    }
}

// *********************************************************** C++ ***********************************************************************

// T.C: O(N+logN)
// S.C: O(N)
class Solution {
  public:
    int minCost(vector<int>& arr) {
        // code here
        int cost = 0;
        
        priority_queue<int, vector<int>, greater<int>> pq;
        
        for(int &it: arr){
            pq.push(it);
        }
        
        while(!pq.empty()){
            int first = pq.top();
            pq.pop();
            
            if(pq.empty()){
                break;
            }
            
            int second = pq.top();
            pq.pop();
            
            int sum = first + second;
            
            cost += sum;
            pq.push(sum);
        }
        
        return cost;
    }
};
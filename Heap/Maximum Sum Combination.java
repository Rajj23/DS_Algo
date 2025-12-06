// ******************************************************************************* JAVA ******************************************************************************

// T.C: O(k log k)
// S.C: O(k)
class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        
        int i = n-1;
        int j = n-1;
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x,y)->y[0]-x[0]);
        
        Set<String> visited = new HashSet<>();
        
        maxHeap.add(new int[]{a[i]+b[j], i, j});
        visited.add(i+"_"+j);
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(k-- > 0){
            int[] top = maxHeap.poll();
            int sum = top[0];
            int x = top[1];
            int y = top[2];
            
            result.add(sum);
            
            if(x-1 >= 0){
                String key = (x-1) + "_" + y;
                if(!visited.contains(key)){
                    visited.add(key);
                    maxHeap.offer(new int[]{a[x-1]+b[y], x-1,y});
                }
            }
            
            if(y-1 >=0){
                String key = x+"_"+(y-1);
                if(!visited.contains(key)){
                    visited.add(key);
                    maxHeap.offer(new int[]{a[x]+b[y-1], x, y-1});
                }
            }
        }
        return result;
    }
}

// ******************************************************************************* C++ ******************************************************************************

// T.C: O(k log k)
// S.C: O(k)

class Solution {
  public:
    vector<int> topKSumPairs(vector<int>& a, vector<int>& b, int k) {
        // code here
        int n = a.size();
        sort(a.begin(),a.end());
        sort(b.begin(),b.end());
         
        vector<int> result;
        unordered_set<string> visited;
        priority_queue<vector<int>, vector<vector<int>>, less<vector<int>>> maxHeap;
        
        int i = n-1;
        int j = n-1;
        
        maxHeap.push({a[i]+b[j],i,j});
        visited.insert(to_string(i) + "_" + to_string(j));
        
        while(k-- >0 && !maxHeap.empty()){
            
            auto top = maxHeap.top();
            maxHeap.pop();
            
            int sum = top[0];
            int x = top[1];
            int y = top[2];
            
            result.push_back(sum);
            
            if(x-1>=0){
                string key = to_string(x - 1) + "_" + to_string(y);
                if(visited.count(key)==0){
                    maxHeap.push({a[x-1]+b[y],x-1,y});
                    visited.insert(key);
                }
            }
            if(y-1>=0){
                string key = to_string(x) + "_" + to_string(y-1);
                if(visited.count(key)==0){
                    maxHeap.push({a[x]+b[y-1],x,y-1});
                    visited.insert(key);
                }
            }
        }
        
        return result;
    }
};
// ***************************************C++******************************************
// Approach 1
// T.C: O(nlogn)
// S.C: O(n)
class Solution {
  public:

    vector<int> replaceWithRank(vector<int> &arr, int N) {
        
        vector<int> sorted = arr;
        sort(sorted.begin(),sorted.end());
        
        unordered_map<int,int> mp;
        int rank=1;
        
        for(int num:sorted){
            if(mp.find(num)==mp.end(num)){
                mp[num] = rank++;
            }
        }
        vector<int> result;
        for(int num:arr){
            result.push_back(mp[num]);
        }
        
        return result;
    }
};

// Approach 2
// T.C: O(nlogn)
// S.C: O(n)
class Solution {
  public:

    vector<int> replaceWithRank(vector<int> &arr, int N){
        vector<int> result(N);
        
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        
        for(int i=0;i<N;i++){
            pq.push({arr[i],i});
        }
        
        int rank=0;
        int prev = INT_MIN;
        
        while(!pq.empty()){
            auto top = pq.top();
            pq.pop();
            
            int curr = top[0];
            int idx = top[1];
            
            if(curr!=prev){
                rank++;
                prev = curr;
            }
            
            result[idx] = rank;
        }
        
        return result;
    }
};


// ***********************************************JAVA**********************************************
// Approach 1
// T.C: O(nlogn)
// S.C: O(n)

class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        // code here
        int[] nums = arr.clone();
        
        Arrays.sort(nums);
        
        Map<Integer,Integer> mp = new HashMap<>();
        
        int rank = 1;
        for(int num:nums){
            if(!mp.containsKey(num)){
                mp.put(num,rank);
                rank++;
            }
        }
        
        int[] result = new int[N];
        
        for(int i=0;i<N;i++){
            int num = arr[i];
            result[i] = mp.get(num);
        }
        
        return result;
    }
}

// Approach 2
// T.C: O(nlogn)
// S.C: O(n)
class Solution {
    static int[] replaceWithRank(int arr[], int N){
        int[] result = new int[N];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        
        for(int i=0;i<N;i++){
            pq.add(new int[]{arr[i],i});
        }
        
        int rank=0;
        int prev = Integer.MIN_VALUE;
        
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int curr = top[0];
            int idx = top[1];
            
            if(curr!=prev){
                rank++;
            }
            
            result[idx] = rank;
            prev = curr;
        }
        
        return result;
    }
}
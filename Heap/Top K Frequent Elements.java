// **************************************************************************** JAVA ************************************************************************************

// T.C: O(nlogn)
// S.C: O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);

        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            pq.add(new int[]{key,value});
        }

        int[] result = new int[k];

        for(int i=0;i<k;i++){

            int[] top = pq.poll();

            result[i] = top[0];
        }

        return result;
    }
}

// **************************************************************************** C++ ************************************************************************************

// T.C: O(nlogn)
// S.C: O(n)
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> mp;

        auto cmp = [](pair<int,int> &a, pair<int,int> &b){
            return a.second < b.second;
        };

        priority_queue<pair<int,int>,vector<pair<int,int>>, decltype(cmp) > pq(cmp);

        for(int num:nums){
            mp[num]++;
        }

        for(auto &it:mp){
            int key = it.first;
            int val = it.second;
            pq.push({key,val});
        }

        vector<int> result;
        for(int i=0;i<k;i++){
            result.push_back(pq.top().first);
            pq.pop();
        }

        return result;
    }
};
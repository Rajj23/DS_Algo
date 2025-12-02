// *************************************** JAVA ****************************************************
// T.C: O(2*N)
// S.C: O(N)
class Solution {
    public int countTrapezoids(int[][] points) {
        int M = 1_000_000_007;
        Map<Integer,Integer> mp = new HashMap<>();

        for(int[] point:points){
            int y = point[1];
            mp.put(y,mp.getOrDefault(y,0)+1);
        }

        long result = 0;
        long prevHorziontalLines = 0;

        for(int count : mp.values()){

            long horizontalLines = (long) count * (count-1)/2;
            
            result += horizontalLines * prevHorziontalLines;

            prevHorziontalLines += horizontalLines;
        }

        return (int)(result % M);
    }
}


// ********************************************* C++ ******************************************************
// T.C: O(2*N)
// S.C: O(N)
class Solution {
public:
    int countTrapezoids(vector<vector<int>>& points) {
        int M = 1e9+7;
        unordered_map<int,int> mp;

        for(auto &point:points){
            int y = point[1];
            mp[y]++;
        }

        long long result = 0;
        long long prevHorizontalLines = 0;

        for(auto &it : mp){
            int count = it.second;

            long long horizontal = (long long)count * (count-1)/2;
            
            result += horizontal * prevHorizontalLines;

            prevHorizontalLines += horizontal;
        }

        return result % M;
    }
};
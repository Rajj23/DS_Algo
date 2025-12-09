/************************************************************ JAVA *****************************************************/

//Approach-1 (Using map : 2 Pass Solution)
//T.C : O(2*n)
//S.C : O(n)
class Solution {
    public int specialTriplets(int[] nums) {
        int M = 1_000_000_007;
        Map<Integer,Integer> rightMap = new HashMap<>();
        Map<Integer,Integer> leftMap = new HashMap<>();
        int result = 0;

        for(int num:nums){
            rightMap.put(num,rightMap.getOrDefault(num,0)+1);
        }

        for(int num:nums){
            rightMap.put(num,rightMap.get(num)-1);

            int left = leftMap.getOrDefault(num*2,0);
            int right = rightMap.getOrDefault(num*2,0);
            
            long add = (1L * left * right) % M;

            result = (int)((result + add)%M);
            leftMap.put(num,leftMap.getOrDefault(num,0)+1);
        }

        return result;

    }
}

//Approach-2 (Using map : 1 Pass Solution)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int specialTriplets(int[] nums) {
        int M = 1_000_000_007;
        Map<Integer,Integer> validI = new HashMap<>();
        Map<Integer,Integer> validJ = new HashMap<>();

        int result = 0;

        for(int num:nums){

            if(num%2==0){
                result = (result + validJ.getOrDefault(num/2,0))%M;
            }

            int updateJ = (validJ.getOrDefault(num,0)+validI.getOrDefault(num*2,0)) % M;
            validJ.put(num,updateJ);

            validI.put(num,validI.getOrDefault(num,0)+1);
        }

        return result;
    }
}


/************************************************************ C++ *****************************************************/

//Approach-1 (Using map : 2 Pass Solution)
//T.C : O(2*n)
//S.C : O(n)
class Solution {
public:
    int specialTriplets(vector<int>& nums) {
        int M = 1e9+7; 
        unordered_map<int,int> leftMap;
        unordered_map<int,int> rightMap;
        int result = 0;

        for(int &num:nums){
            rightMap[num]++;
        }

        for(int &num:nums){
            rightMap[num]--;

            int left = leftMap[num*2];
            int right = rightMap[num*2];

            long long add = (1LL * left * right)%M;
            result = (result + add)%M;

            leftMap[num]++;
        }

        return result;
    }
};

//Approach-2 (Using map : 1 Pass Solution)
//T.C : O(n)
//S.C : O(n)
class Solution {
public:
    int specialTriplets(vector<int>& nums) {
        int M = 1e9+7;
        unordered_map<int,int> validI;
        unordered_map<int,int> validJ;
        int result = 0;

        for(int &num:nums){

            if(num%2==0){
                result = (result + validJ[num/2])%M;
            }

            int updateJ = (validI[num*2] + validJ[num])%M;
            validJ[num] = updateJ;

            validI[num]++;
        }

        return result;
    }
};
// ************************************************ JAVA *********************************************************

// T.C: O(nlogn)
// S.C: O(n)
class Solution {
    public boolean isNStraightHand(int[] hands, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int hand:hands){
            pq.add(hand);
        }

        while(!pq.isEmpty()){
            int currGroup = 0;
            int prev = -1;
            List<Integer> temp = new ArrayList<>();

            for(int i=0;i<groupSize;i++){
                if(pq.isEmpty()){
                    return false;
                }

                int curr = pq.poll();
                if(curr==prev){
                    temp.add(curr);
                    i--;
                }
                else if(prev+1==curr || prev==-1){
                    currGroup++;
                }
                else{
                    return false;
                }
                prev = curr;
            }

            for(int it:temp){
                pq.add(it);
            }

            if(currGroup!=groupSize){
                return false;
            }
        }
        return true;
    }
}



// ************************************************** C++ **************************************************************

// T.C: O(nlogn)
// S.C: O(n)
class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        priority_queue<int, vector<int>, greater<int>> pq;

        for(int &it:hand){
            pq.push(it);
        }

        while(!pq.empty()){
            int prev = -1;
            int currGroupSize = 0;
            vector<int> temp;

            for(int i=0;i<groupSize;i++){
                if(pq.empty()) return false;

                int curr = pq.top();
                pq.pop();

                if(prev==-1){
                    currGroupSize++;
                }
                else if(prev==curr){
                    temp.push_back(curr);
                    i--;
                    continue;
                }
                else if(prev+1==curr){
                    currGroupSize++;
                }
                else{
                    return false;
                }

                prev = curr;
            }

            for(int &it : temp){
                pq.push(it);
            }

            if(currGroupSize!=groupSize){
                return false;
            }
        }

        return true;
    }
};
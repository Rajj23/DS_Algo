// *************************************************** JAVA **********************************************************

// T.C: O(N*log26)
// S.C: O(2N)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] mp = new int[26];

        for(char ch:tasks){
            mp[ch-'A']++;
        }

        int time = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<26;i++){
            if(mp[i]>0){
                pq.add(mp[i]);
            }
        }

        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();

            for(int i=1;i<=n+1;i++){
                
                if(!pq.isEmpty()){
                    int freq = pq.poll();
                    freq--;
                    temp.add(freq);
                }
            }
            for(int f:temp){
                if(f>0){
                    pq.add(f);
                }
            }

            if(pq.isEmpty()){
                time += temp.size();
            }
            else{
                time += n+1;
            }
        }
        return time;
    }
}

// ************************************************* C++ *********************************************************

// T.C: O(*log26)
// S.C: O(2N)
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int mp[26];

        for(char &ch: tasks){
            mp[ch-'A']++;
        }

        priority_queue<int> pq;

        for(int i=0;i<26;i++){
            if(mp[i]>0){
                pq.push(mp[i]);
            }
        }
        
        int time = 0;
        while(!pq.empty()){
            vector<int> temp;

            for(int i=1;i<=n+1;i++){
                if(!pq.empty()){
                    int freq = pq.top();
                    pq.pop();
                    freq--;
                    temp.push_back(freq);
                }
            }

            for(int &f:temp){
                if(f>0){
                    pq.push(f);
                }
            }

            if(pq.empty()){
                time += temp.size();
            }
            else{
                time += n+1;
            }
        }
        return time;
    }
};
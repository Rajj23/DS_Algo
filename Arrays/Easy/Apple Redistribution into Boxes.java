// Approach: 1
// T.C: O(nlogn + m)
// S.C: O(1)
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int totalApple = 0;
        for(int a:apple){
            totalApple+=a;
        }

        int currCap = 0;
        int n = capacity.length;
        for(int i=0;i<n;i++){
            currCap += capacity[n-i-1];
            if(currCap>=totalApple){
                return i+1;
            }
        }
        return n;
    }
}

// Approach: 2
//T.C : O(n + m)
//S.C : O(1)

class Solution {
public int minimumBoxes(int[] apple, int[] capacity) {
    int totalApple = 0;
    for(int a:apple){
        totalApple+=a;
    }

    int[] freq = new int[51];
    for(int cap:capacity){
        freq[cap]++;
    }

    int count = 0;

    int idx = 0;
    for(int cap=50;cap>=1 && totalApple>0;cap--){
        while(freq[cap] > 0 && totalApple > 0){
            totalApple -= cap;
            freq[cap]--;
            count++;
        }
    }


    return count;
}
}
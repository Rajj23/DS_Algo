// T.C: O(log(n))
// S.C: O(32)
class Solution {
    public int binaryGap(int n) {
        int[] bit = new int[32];

        int idx = 0;

        while(n != 0){
            bit[idx++] = n%2;

            n /= 2;
        }

        int i = -1, j = 0;
        int ans = 0;

        while(j < 32){
            if(bit[j] == 1){
                if(i == -1){
                    i = j;
                }
                else{
                    ans = Math.max(ans, j-i);
                    i = j;
                }
            }
            j++;
        }

        return ans;
    }
}

// T.C: O(log(n))
// S.C: O(1)
class Solution {
    public int binaryGap(int n) {
        int currBitPos = 0;
        int prevBitPos = -1;
        
        int result = 0;

        while(n != 0){
            int bit = n % 2;

            if(bit == 1){
                result = (prevBitPos != -1) ? Math.max(result, currBitPos - prevBitPos) : result;
                prevBitPos = currBitPos;
            }
            currBitPos++;

            n /= 2;
        }

        return result;
    }
}


// T.C: O(32)
// S.C: O(1)
class Solution {
    public int binaryGap(int n) {
        int prev = -1;

        int result = 0;

        for(int curr = 0; curr < 32; curr++){
            if(((n >> curr) & 1) > 0){
                result = (prev != -1) ? Math.max(result, curr - prev) : result;
                prev = curr;
            }
        }

        return result;
    }
}
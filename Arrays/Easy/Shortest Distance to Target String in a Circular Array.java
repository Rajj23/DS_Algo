// T.C: O(n)
// S.C: O(1)
import java.util.*;
class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int result = Integer.MAX_VALUE;
        int n = words.length;

        for(int i = 0; i < n; i++){
            if(target.equals(words[i])){
                int dist = Math.abs(startIndex - i);
                int diff = Math.min(dist, n-dist);
                result = Math.min(result, diff);
            }

        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
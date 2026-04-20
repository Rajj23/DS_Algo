// Approach: 1
// T.C: O(n*n)
// S.C: O(1)
class Solution {
    public int maxDistance(int[] colors) {
        int ans = 0;
        int n = colors.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(colors[i] != colors[j]){
                    ans = Math.max(ans, Math.abs(i-j));
                }
            }
        }
        return ans;
    }
}


// Approach: 2
// T.C: O(n*n)
// S.C: O(1)
class Solution {
    public int maxDistance(int[] colors) {
        int ans = 0;
        int n = colors.length;

        for(int i = 0; i < n; i++){
            for(int j = n-1; j > i; j--){
                if(colors[i] != colors[j]){
                    ans = Math.max(ans, Math.abs(i-j));
                    break;
                }
            }
        }
        return ans;
    }
}


// Approach: 3
// T.C: O(n)
// S.C: O(1)
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;

        int i = 0;
        while(colors[i] == colors[n-1]){
            i++;
        }
        int ans = Math.abs(n-1-i);

        i = n-1;
        while(colors[0] == colors[i]){
            i--;
        }

        ans = Math.max(ans, i);
        return ans;
    }
}


// Approach: 4
// T.C: O(n)
// S.C: O(1)
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;

        int ans = 0;
        for(int i = 0; i < n; i++){
            if(colors[i] != colors[0]){
                ans = Math.max(ans, i);
            }
            if(colors[i] != colors[n-1]){
                ans = Math.max(ans, n-i-1);
            }
        }
        return ans;
    }
}
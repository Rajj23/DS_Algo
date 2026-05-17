// T.C: O(n)
// S.C: O(1)
class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        int n = s.length();

        for(int i = 0; i < n; i++){
            int idx = s.charAt(i) - 'a';
            if(pos[idx] == -1){
                pos[idx] = i;
            }
            else{
                int prev = pos[idx];
                int diff = Math.abs(prev - i) - 1;
                if(distance[idx] != diff) return false;
            }
        }
        return true;
    }
}
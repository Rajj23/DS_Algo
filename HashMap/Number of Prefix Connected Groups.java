// T.C: O(n)
// S.C: O(n)
class Solution {
    public int prefixConnected(String[] words, int k) {
        int count = 0;
        int n = words.length;

        Map<String, Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++){
            String s = words[i];
            if(s.length() < k) continue;

            String sub = s.substring(0, k);
            mp.put(sub, mp.getOrDefault(sub, 0)+1);
        }

        for(int val : mp.values()){
            if(val >= 2){
                count++;
            }
        }

        return count;
    }
}
// Approach: Trying all 
// T.C: O(n*n)
// S.C: O(n)
class Solution {
    boolean isAng(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int n = s1.length();

        int[] freq = new int[26];


        for(int i = 0; i < n; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            freq[ch1-'a']++;
            freq[ch2-'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] != 0) return false;
        }

        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int n = strs.length;

        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;

            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            visited[i] = true;

            for(int j = i+1; j < n; j++){
                if(isAng(strs[i], strs[j])){
                    list.add(strs[j]);
                    visited[j] = true;
                }
            }
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}

// Approach: Using HashMap
// T.C: O(m*n)
// S.C: O(2n)
class Solution {

    String getKey(String s){
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                sb.append(i + "_" + freq[i] + "_");
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        int n = strs.length;

        for(int i = 0; i < n; i++){
            String key = getKey(strs[i]);

            mp.computeIfAbsent(key, k-> new ArrayList<>()).add(strs[i]);
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> value : mp.values()){
            result.add(new ArrayList<>(value));
        }

        return result;
    }
}
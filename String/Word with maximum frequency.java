// T.C: O(2n)
// S.C: O(2n)
class Solution {
    public String maximumFrequency(String s) {
        // Your Code goes here
        Map<String, Integer> freq = new HashMap<>();
        
        String[] arr = s.split("\\s+");
        
        for(String word : arr){
            freq.put(word, freq.getOrDefault(word, 0)+1);
        }
        
        int max = 0;
        String word = "";
        
        for(String key : arr){
            int val = freq.get(key);
            if(max < val){
                max = val;
                word = key;
            }
        }
        
        return word + " " + max;
    }
}
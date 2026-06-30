// T.C: O(n)
// S.C: O(1)
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        int n = s.length();

        List<List<Integer>> result = new ArrayList<>();
        int i = 0;

        while(i < n){
            int start = i;

            while(i < n && s.charAt(start) == s.charAt(i)){
                i++;
            }

            int len = i - start;
        
            if(len >= 3){
                result.add(Arrays.asList(start, i -1));
            }
            
        }

        return result;
    }
}
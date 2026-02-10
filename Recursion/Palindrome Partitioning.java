// T.C: O(n!)
// S.C: O(n)
class Solution {
    void solve(int idx, String s, List<List<String>> result, List<String> list){
        if(idx == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = idx; i < s.length(); i++){
            if(isValid(s, idx, i)){
                list.add(s.substring(idx, i+1));
                solve(i+1, s, result, list);
                list.remove(list.size()-1);
            }
        }
    }

    boolean isValid(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        solve(0, s, result, new ArrayList<>());

        return result;
    }
}
// T.C: O(n^2)
// S.C: O(1)
class Solution {
    String solve(String s){
        List<String> specials = new ArrayList<>();

        int start = 0;
        int sum = 0;

        for(int i = 0; i < s.length(); i++){
            sum += s.charAt(i) == '1' ? 1 : -1;

            if(sum == 0){
                String inner = s.substring(start+1, i);
                specials.add("1" + solve(inner) + "0");
                start = i + 1;
            }
        }

        Collections.sort(specials, Collections.reverseOrder());

        String result = "";

        for(String str : specials){
            result += str;
        }

        return result;
    }

    public String makeLargestSpecial(String s) {
        return solve(s);
    }
}
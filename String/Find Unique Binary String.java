//Approach-2 (Using generating all substring of lenght n)
//T.C : O(n^2) - 
//S.C : O(n) - Using set
class Solution {
    String solve(int i, StringBuilder sb, Set<String> st, int n){
        if(i == n){
            if(!st.contains(sb.toString())){
                return sb.toString();
            }
            return "";
        }

        // 0 case
        sb.append("0");
        String zero = solve(i+1, sb, st, n);
        if(!zero.equals("")) return zero;
        sb.deleteCharAt(sb.length()-1);

        // 1 case
        sb.append("1");
        String one = solve(i+1, sb, st, n);
        if(!one.equals("")) return one;
        sb.deleteCharAt(sb.length()-1);

        return "";
    }

    public String findDifferentBinaryString(String[] nums) {
        Set<String> st = new HashSet<>();
        int n = nums[0].length();
        for(String num : nums){
            st.add(num);
        }
        return solve(0, new StringBuilder(), st, n);
    }
}


//Approach-2 (Using simple conversion)
//T.C : O(n^2) - Iterating on each string and converting each character to integer
//S.C : O(n) - Using set
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> st = new HashSet<>();

        for(String num : nums){
            st.add(Integer.parseInt(num, 2));
        }

        int n = nums.length;

        String result = "";
        for(int number = 0; number <= n; number++){
            
            if(!st.contains(number)){
                result = Integer.toBinaryString(number);

                while(result.length() < n){
                    result = "0" + result;
                }

                return result;
            }
        }

        return "";
    }
}


//Approach-3 (By discarding matching characters in each position)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            char ch = nums[i].charAt(i);

            result.append(ch == '0' ? "1" : "0");
        }
        return result.toString();
    }
}
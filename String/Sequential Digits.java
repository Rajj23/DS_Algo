// T.C: O(log(n))
// S.C: O(1)
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        int n = String.valueOf(low).length();
        int m = String.valueOf(high).length();

        String digit = "123456789";

        for(int len = n; len <= m; len++){
            
            for(int i = 0; i + len <= digit.length(); i++) {
                int value = Integer.parseInt(digit.substring(i, i + len));

                if(value >= low && value <= high){                    
                    result.add(value);
                }
            }

        }

        return result;
    }
}
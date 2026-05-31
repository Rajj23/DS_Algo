// T.C: O(log(n))
// S.C: O(log(n))
class Solution {
    public int digitFrequencyScore(int n) {
        Map<Integer, Integer> freq = new HashMap<>();

        while(n != 0){
            int dig = n%10;
            freq.put(dig, freq.getOrDefault(dig, 0)+1);

            n /= 10;
        }

        int sum = 0;

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();

            sum += (val * key);
        }
        return sum;
    }
}
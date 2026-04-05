// T.C: O(nlogn)
// S.C: O(n)
class Solution {
    public List<Integer> findGoodIntegers(int n) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> mp = new HashMap<>();

        for(int a = 1; a <= 1000; a++){
            int a3 = (a * a * a);
            for(int b = a; b <= 1000; b++){
                int b3 = (b * b * b);
                int sum = a3+b3;
                if(sum <= n){
                    mp.put(sum, mp.getOrDefault(sum, 0)+1);
                }
            }
        }

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();

            if(val >= 2){
                result.add(key);
            }
        }
        Collections.sort(result);
        return result;
    }
}
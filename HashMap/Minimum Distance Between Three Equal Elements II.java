//Approach - Optimal : Using map forstoring indices and checking for 3 indices for a number 
//T.C : O(2n)
//S.C : O(n)
class Solution {
    public int minimumDistance(int[] nums) {
        if(nums.length < 3) return -1;
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        

        int result = Integer.MAX_VALUE;

        for(Map.Entry<Integer, List<Integer>> entry : mp.entrySet()){
            List<Integer> arr = entry.getValue();

            if(arr.size() < 3) continue;
            Collections.sort(arr);
            for(int i = 0; i < arr.size() - 2; i++){
                int a = arr.get(i);
                int b = arr.get(i+1);
                int c = arr.get(i+2);
                int val = Math.abs(a-b) + Math.abs(b-c) + Math.abs(c-a);
                result = Math.min(result, val);
            }

        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}

//Approach - Optimal : Using map forstoring indices and checking for 3 indices for a number 
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int minimumDistance(int[] nums) {
        if(nums.length < 3) return -1;
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            if(mp.get(nums[i]).size() > 2){
                List<Integer> list = mp.get(nums[i]);
                
                int k = list.get(list.size()-3);

                result = Math.min(result, 2*(i-k));
            }

        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
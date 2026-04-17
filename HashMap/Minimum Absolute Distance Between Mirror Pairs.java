//Approach - Store nums in map - binary search and find
//T.C : O(n * log(n))
//S.C : O(n)
class Solution {
    int reverse(int num) {
        int val = 0;

        while (num != 0) {
            val = val * 10 + num % 10;
            num /= 10;
        }
        return val;
    }

    int search(List<Integer> list, int tar) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (tar > list.get(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return -1;

        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int rev = reverse(nums[i]);
            if(rev == -1) continue;

            if (mp.containsKey(rev)) {
                List<Integer> temp = mp.get(rev);
                int pos = search(temp, i);

                if (pos < temp.size()) {
                    int j = temp.get(pos);
                    if(i < j){
                        result = Math.min(result, Math.abs(j - i));
                    }
                }
                if (pos+1 < temp.size()) {
                    int j = temp.get(pos+1);
                    if(i < j){
                        result = Math.min(result, Math.abs(j - i));
                    }
                }
                if (pos - 1 >= 0) {
                    int j = temp.get(pos - 1);
                    if(i < j)
                        result = Math.min(result, Math.abs(j - i));
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}


//Approach - Store reverses in map - iterate and find
//T.C : O(n * log(10(num)))
//S.C : O(n)
class Solution {
    int reverse(int num) {
        int val = 0;

        while (num != 0) {
            val = val * 10 + num % 10;
            num /= 10;
        }
        return val;
    }
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return -1;

        Map<Integer, Integer> mp = new HashMap<>();
       
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(mp.containsKey(nums[i])){
                result = Math.min(result, i - mp.get(nums[i]));
            }

            mp.put(reverse(nums[i]), i);
            
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
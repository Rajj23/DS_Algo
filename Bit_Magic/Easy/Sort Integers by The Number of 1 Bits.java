// T.C: O(n log n)
// S.C: O(n)
class Solution {
    public int[] sortByBits(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);

        for(int i = 0; i < 32; i++){
            list.add(new ArrayList<>());
        }

        for(int num : arr){
            int bits = Integer.bitCount(num);
            list.get(bits).add(num);
        }
        int n = arr.length;
        int[] result = new int[n];
        int idx = 0;
        
        for(int i = 0; i < 32; i++){
            List<Integer> subList = list.get(i);

            for(int j = 0; j < subList.size(); j++){
                result[idx++] = subList.get(j);
            }
        }

        return result;
    }
}


// T.C: O(n log n)
// S.C: O(n)
class Solution {
    public int[] sortByBits(int[] nums) {

        List<Integer> list = Arrays.stream(nums)
                           .boxed()
                           .collect(Collectors.toList());

        list.sort((a, b)->{
            if(Integer.bitCount(a) == Integer.bitCount(b)){
                return Integer.compare(a, b);
            }
            return Integer.compare(Integer.bitCount(a), Integer.bitCount(b));
        });

        for(int i = 0; i < nums.length; i++){
            nums[i] = list.get(i);
        }
        return nums;
    }
}
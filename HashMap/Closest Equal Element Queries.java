//Approach - Store in map and use binary search to find indices
//T.C : O(Q * log(n))
//S.C : O(n)
class Solution {
    int search(List<Integer> list, int tar){
        int pos = -1;

        int low = 0, high = list.size() - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(list.get(mid) == tar){
                pos = mid;
                break;
            }
            else if(list.get(mid) > tar){
                high = mid - 1;
            }
            else{
                low = mid+1;
            }
        }
        return pos;
    }
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = queries.length;
        int m = nums.length;

        Map<Integer, List<Integer>> mp = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < m; i++){
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for(int i = 0; i < n; i++){
            int q = queries[i];
            int key = nums[q];
            List<Integer> temp = mp.get(key);

            if(temp.size() <= 1){
                result.add(-1);
                continue;
            }
            int min = Integer.MAX_VALUE;
            int pos = search(temp, q);
            int sz = temp.size();

            int r = temp.get((pos+1)%sz);
            int dist = Math.abs(q - r);
            int diff = Math.min(dist, m-dist);
            min = Math.min(min, diff);

            int l = temp.get((pos-1+sz)%sz);
            dist = Math.abs(l-q);
            diff = Math.min(dist, m-dist);
            min = Math.min(min, diff);

            result.add(min);
        }
        return result;
    }
}
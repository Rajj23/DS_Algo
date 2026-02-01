//T.C : O(2n)
//S.C : O(n)
class Solution {
    public int minimumCost(int[] nums) {
        int totalCost = nums[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i < nums.length; i++){
            pq.add(nums[i]);
        }
        for(int i = 0; i < 2; i++){
            totalCost += pq.poll();
        }

        return totalCost;
    }
}

//T.C : O(2n)
//S.C : O(1)
class Solution {
    public int minimumCost(int[] nums){
        int totalCost = nums[0];

        int first = Integer.MAX_VALUE;
        int firstIdx = -1;
        int second = Integer.MAX_VALUE;

        for(int i = 1; i < nums.length; i++){
            if(first > nums[i]){
                first = nums[i];
                firstIdx = i;
            }
        }

        for(int i = 1; i < nums.length; i++){
            if(firstIdx == i) continue;

            second = Math.min(second, nums[i]);
        }

        return totalCost + first + second;
    }
}

//Approach (Just find minimums)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int minimumCost(int[] nums){
        int score = nums[0];

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] < first){
                second = first;
                first = nums[i];
            }
            else if(nums[i] < second){
                second = nums[i];
            }
        }

        return score + first + second;
    }
}

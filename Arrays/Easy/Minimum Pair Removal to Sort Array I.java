//Approach (Simple simulation)
//T.C : O(n^2)
//S.C : O(1)
class Solution {
    boolean isSorted(List<Integer> list){
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) > list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    int minPair(List<Integer> list){
        int minIndex = -1;
        int minSum = Integer.MAX_VALUE;

        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) + list.get(i+1) < minSum){
                minIndex = i;
                minSum = list.get(i) + list.get(i+1);
            }
        }
        return minIndex;
    }

    public int minimumPairRemoval(int[] nums) {
        int count = 0;
        int n = nums.length;

        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            list.add(num);
        }

        int operations = 0;

        while(!isSorted(list)){
            int index = minPair(list);

            int sum = list.get(index) + list.get(index + 1);
            list.set(index, sum);
            list.remove(index+1);

            operations++;
        }

        return operations;
    }
}
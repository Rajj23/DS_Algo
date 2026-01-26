//Approach (Sort and find and collect)
//T.C : O(nlogn) 
//S.C : O(1)
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        int minDiff = Integer.MAX_VALUE;
    
        for(int i = 0; i < n-1; i++){
            minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[i+1]));
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n-1; i++){
            if(Math.abs(arr[i] - arr[i+1]) == minDiff){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);

                result.add(temp);
            }
        }
        return result;
    }
}   
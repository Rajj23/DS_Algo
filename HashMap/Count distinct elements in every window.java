// T.C: O(n)
// S.C: O(k)
class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0;
        while(j < k){
            mp.put(arr[j], mp.getOrDefault(arr[j], 0)+1);
            j++;
        }
        
        while(j < n){
            result.add(mp.size());
            
            mp.put(arr[i], mp.get(arr[i])-1);
            if(mp.get(arr[i]) == 0) mp.remove(arr[i]);
            
            mp.put(arr[j], mp.getOrDefault(arr[j], 0)+1);
            
            i++;
            j++;
        }
        result.add(mp.size());
        
        return result;
    }
}
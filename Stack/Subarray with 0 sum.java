// T.C: O(n)
// S.C: O(n)
class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[]) {
        // Your code here
        Set<Integer> st = new HashSet<>();
        int sum = 0;
        st.add(0);
        for(int a : arr){
            sum += a;
            if(st.contains(sum)) return true;
            
            st.add(sum);
        }
        
        return false;
    }
}
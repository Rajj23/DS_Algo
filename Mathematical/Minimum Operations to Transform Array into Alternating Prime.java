// T.C: O(n * sqrt(max(nums)))
// S.C: O(1)
class Solution {
    boolean isPrime(int num){
        if(num <= 1) return false;
        
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                if(!isPrime(nums[i])){
                    int val = nums[i];
                    while(!isPrime(val)){
                        val++;
                    }
                    count += (val - nums[i]);
                }
            }
            else{
                if(isPrime(nums[i])){
                    int val = nums[i];
                    while(isPrime(val)){
                        val++;
                    }
                    count += (val - nums[i]);
                }
            }
        }
        return count;
    }
}
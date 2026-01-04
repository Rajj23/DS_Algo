// T.C: O(n * sqrt(maxNum))
// S.C: O(1)
class Solution {
    int result = 0;

    public void divAdd(int num){
        int divCount = 0;
        int sum = 0;

        for(int i=1;i*i<=num;i++){
            if(num%i == 0){
                divCount++;
                sum += i;
                if(i != num/i){
                    divCount++;
                    sum += num/i;
                }
            }
            
            if(divCount > 4) return;
        }
        if(divCount == 4){
            result += sum;
        }
    }

    public int sumFourDivisors(int[] nums) {
        for(int num:nums){
            divAdd(num);
        }
        return result;
    }
}
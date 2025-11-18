//Approach-1 (Iterating from left to right)
// T.C : O(N)
// S.C : O
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;

        int i=0;
        while(i<n){
            if(bits[i]==1){
                i+=2;
            }
            else{
                if(i==n-1){
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}





//Approach-2 (Iterating from right to left and counting streak of 1s just after last 0)
//T.C : O(n) 
//S.C : O(1)
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        
        int n = bits.length;
        int count1 = 0;

        for(int i=n-2;i>=0 && bits[i]==1;i--){
            count1++;
        }
        
        return count1%2==0 ? true : false;
    }
}
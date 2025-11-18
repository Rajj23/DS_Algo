// Approach 1
// T.C : O(2N)
// S.C : O(3)
class Solution {
    public int totalFruit(int[] fruits) {
        int maxPick = 0;
        int l=0,r=0;
        int n = fruits.length;
        Map<Integer,Integer> mp = new HashMap<>();

        while(r<n){
            mp.put(fruits[r],mp.getOrDefault(fruits[r],0)+1);
            
            while(mp.size()>2){
                mp.put(fruits[l],mp.get(fruits[l])-1);
                if(mp.get(fruits[l])==0){
                    mp.remove(fruits[l]);
                }
                l++;
            }
            if(mp.size()<=2){
                maxPick = Math.max(maxPick,r-l+1);
            }
            r++;
        }
        return maxPick;
    }
}


// Approach 2
// T.C : O(N)
// S.C : O(3)
class Solution {
    public int totalFruit(int[] fruits) {
       int maxLen = 0;
        int l=0,r=0;
        Map<Integer,Integer> mp = new HashMap<>();

        while(r<fruits.length){
            mp.put(fruits[r],mp.getOrDefault(fruits[r],0)+1);
            
            if(mp.size()>2){
                mp.put(fruits[l],mp.get(fruits[l])-1);
                if(mp.get(fruits[l])==0){
                    mp.remove(fruits[l]);
                }
                l++;
            }
            if(mp.size()<=2){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}
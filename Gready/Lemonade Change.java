// ************************************************************* JAVA *************************************************************************

// Approach-1
// T.C: O(n)
// S.C: O(3)
class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer,Integer> mp = new HashMap<>();

        for(int bill:bills){
            mp.put(bill,mp.getOrDefault(bill,0)+1);

            if(bill==20){
                if(mp.containsKey(10) && mp.get(10)>0){
                    mp.put(10,mp.get(10)-1);
                    bill = 10;
                }
                else if(mp.containsKey(5) && mp.get(5)>2){
                    mp.put(5,mp.get(5)-3);
                    bill = 5;
                }
            }

            if(bill==10){
                if(mp.containsKey(5) && mp.get(5)>0){
                    mp.put(5,mp.get(5)-1);
                    bill = 5;
                }
            }
            if(bill>5){
                return false;
            }
        }
        return true;
    }
}


// Approach-2
// T.C: O(n)
// S.C: O(1)
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for(int bill:bills){
            if(bill==5){
                five++;
            }
            else if(bill==10){
                if(five>0){
                    ten++;
                    five--;
                }
                else{
                    return false;
                }
            }
            else{
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }
                else if(five>2){
                    five-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
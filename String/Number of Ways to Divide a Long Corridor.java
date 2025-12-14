// T.C: O(2n)
// S.C: O(s)
class Solution {
    public int numberOfWays(String corridor) {
        int M = 1_000_000_007;
        int n = corridor.length();
        List<Integer> pos_seats = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(corridor.charAt(i)=='S'){
                pos_seats.add(i);
            }
        }
        if(pos_seats.size()%2!=0 || pos_seats.size()==0){
            return 0;
        }

        long result = 1;
        int end_idx_prev = pos_seats.get(1);
        for(int i=2;i<pos_seats.size();i+=2){
            int length = pos_seats.get(i) - end_idx_prev;

            result = (result * length) %M;
            end_idx_prev = pos_seats.get(i+1);
        }    

        return (int) result;    
    }
}
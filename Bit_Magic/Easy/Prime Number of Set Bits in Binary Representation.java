//T.C : O((right - left) * log(num))
//S.C : O(1)
class Solution {
    boolean isValid(int num){
        if(num < 2) return false;

        for(int i = 2; i*i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        
        for(int i = left; i <= right; i++){
            int bits = Integer.bitCount(i);
            if(isValid(bits)){
                count++;
            }
        }

        return count;
    }
}


//Approach (Simple loop and check)
//T.C : O((right - left) * log(num))
//S.C : O(1)
class Solution {
    Set<Integer> st = new HashSet<>();

    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        st.add(2);
        st.add(3);
        st.add(5);
        st.add(7);
        st.add(11);
        st.add(13);
        st.add(17);
        st.add(19);
        st.add(23);
        st.add(29);
        st.add(31);
        
        for(int i = left; i <= right; i++){
            int bits = Integer.bitCount(i);
            if(st.contains(bits)){
                count++;
            }
        }

        return count;
    }
}
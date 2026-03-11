//Approach-1
//T.C : O(log(n))
//S.C : O(log(n))
class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        List<Integer> bits = new ArrayList<>();

        while(n != 0){
            int bit = n % 2;
            if(bit == 1) bits.add(0);
            else bits.add(1);

            n = n >> 1;
        }

        Collections.reverse(bits);
        int result = 0;
        for(int bit : bits){
            System.out.println(bit);
            result = (result << 1) + bit;
        }

        return result;
    }
}


//Approach-2
//T.C : O(log(n))
//S.C : O(1)
class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int result = 0;
        int digit = 0;

        while(n != 0){
            int bit = n % 2;
            
            result += (int) Math.pow(2, digit) * (1 - bit);
            digit++;
            n = n >> 1;
        }


        return result;
    }
}


//Approach-3
//T.C : O(log(n))
//S.C : O(1)
class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;

        int mask = 1;

        while(mask < n){
            mask = (mask << 1) | 1;
        }

        return n ^ mask;
    }
}


//Approach-4
//T.C : O(1)
//S.C : O(1)
class Solution {
    public int bitwiseComplement(int n) {
        int bits = (int) (Math.log(n) / Math.log(2)) + 1;

        int mask = (1 << bits) - 1;

        return n ^ mask; 
    }
}
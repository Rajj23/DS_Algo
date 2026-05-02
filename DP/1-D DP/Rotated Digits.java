//Approach-1 (Brute Force SImulation)
//T.C : O(n)
//S.C : O(n* log10(num))
class Solution {
    Map<Integer, Integer> mp = new HashMap<>();

    boolean isGood(int num){
        int result = 0;
        int temp = num;
        int place = 1;
        while(num > 0){
            int digit = num%10;

            if(!mp.containsKey(digit)) return false;
            int val = mp.get(digit);

            result += val * place;

            num /= 10;
            place *= 10;
        }
        return temp != result;
    }

    public int rotatedDigits(int n) {
        mp.put(0, 0);
        mp.put(1, 1);
        mp.put(2, 5);
        mp.put(5, 2);
        mp.put(6, 9);
        mp.put(8, 8);
        mp.put(9, 6);

        int count = 0;
        for(int i = 1; i <= n; i++){
            if(isGood(i)){
                count++;
            }
        }

        return count;
    }
}


//Approach-2 (Brute Force SImulation)
//T.C : O(n)
//S.C : O(n* log10(num))
class Solution {
    boolean isGood(int num){
        boolean changed = false;
        while(num > 0){
            int digit = num%10;

            if(digit == 3 || digit == 4 || digit == 7) return false;
            if(digit == 2 || digit == 5 || digit == 9 || digit == 6){
                changed = true;
            }

            num /= 10;
        }
        return changed;
    }

    public int rotatedDigits(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(isGood(i)){
                count++;
            }
        }

        return count;
    }
}



//Approach-3 (Recursion Memo)
//T.C : O(n)
//S.C : O(n)
class Solution {
    int[] t;
    int solve(int num){
        if(num == 0){
            return 0;
        }

        if(t[num] != -1) return t[num];

        int rem = solve(num/10);

        if(rem == 2)  return t[num] = 2;

        int digit_check;
        int d = num%10;

        if(d == 0 || d == 1 || d == 8)
            digit_check = 0;
        else if(d == 2 || d == 5 || d == 6 || d == 9)
            digit_check = 1;
        else 
            return t[num] = 2;
        
        if(rem == 1 || digit_check == 1)
            return t[num] = 1;

        
        return t[num] = 0;
    }

    public int rotatedDigits(int n) {
        int count = 0;
        t = new int[n+1];
        Arrays.fill(t, -1);

        for(int i = 1; i <= n; i++){
            if(solve(i) == 1){
                count++;
            }
        }
        return count;
    }
}


//Approach-4 (Bottom Up)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int rotatedDigits(int n) {
        int[] t = new int[n+1];
        Arrays.fill(t, -1);

        t[0] = 0;
        int count = 0;

        for(int i = 1; i <= n; i++){
            int remain = t[i/10];

            if(remain == 2){
                t[i] = 2;
                continue;
            }

            int d = i%10;
            int digit_check;

            if(d == 0 || d ==1 || d == 8){
                digit_check = 0;
            }
            else if(d == 2|| d == 5 || d == 6 || d == 9){
                digit_check = 1;
            }
            else{
                t[i] = 2;
                continue;
            }

            if(remain == 0 && digit_check == 0){
                t[i] = 0;
            }
            else{
                t[i] = 1;
            }

            if(t[i] == 1){
                count++;
            }
        }
        return count;
    }
}
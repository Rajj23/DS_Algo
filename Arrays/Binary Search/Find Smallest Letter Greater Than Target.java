// T.C: O(n)
// S.C: O(1)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for(char ch : letters){
            if(ch > target) return ch;
        }

        return letters[0];
    }
}

// T.C: O(log(n))
// S.C: O(1)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;

        int l = 0;
        int r = n-1;

        int mid = 0;
        int pos = -1;

        while(l <= r){
            mid = l + (r-l)/2;

            if(letters[mid] > target){
                pos = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        if(pos == -1) return letters[0];
        return letters[pos];
    }
}
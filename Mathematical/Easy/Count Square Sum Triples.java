// ******************************************************************************* C++ ***************************************************************************

// T.C: O(n*n*logn)
// S.C: O(1)
class Solution {
    public int countTriples(int n) {
        int result = 0;
        for(int a=1;a<=n;a++){
            for(int b=a+1;b<=n;b++){
                int sum = a*a+b*b;
                int sqrt = (int) Math.sqrt(sum);
                if(sqrt<=n && sqrt*sqrt==sum){
                    result+=2;
                }
            }
        }
        return result;
    }
}



// ******************************************************************************* C++ ***************************************************************************

// T.C: O(n*n*logn)
// S.C: O(1)
class Solution {
public:
    int countTriples(int n) {
        int result = 0;
        for(int a=1;a<=n;a++){
            for(int b=a+1;b<=n;b++){
                int sum = a*a + b*b;
                int sq = sqrt(sum);
                if(sq<=n && sq*sq==sum){
                    result+=2;
                }
            }
        }   
        return result;
    }
};
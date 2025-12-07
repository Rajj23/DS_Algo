// ******************************************************************************** C++ ****************************************************************************

// Approach 1
// T.C: O(1)
// S.C: O(1)
class Solution {
    public int countOdds(int low, int high) {
        int n = high-low+1;
        if(low%2!=0 && high%2!=0){
            return n/2 + 1;
        }
        return n/2;
    }
}


// Approach 2
// T.C: O(1)
// S.C: O(1)
class Solution {
    public int countOdds(int low, int high) {
        return (high+1)/2 - low/2;
    }
}

// ******************************************************************************** C++ ****************************************************************************

// Approach 1
// T.C: O(1)
// S.C: O(1)
class Solution {
public:
    int countOdds(int low, int high) {
        int n = high-low+1;
        if(low%2!=0 && high%2!=0){
            return n/2 + 1;
        }
        return n/2;
    }
};


// Approach 2
// T.C: O(1)
// S.C: O(1)
class Solution {
public:
    int countOdds(int low, int high) {
        return (high+1)/2 - low/2;
    }
};
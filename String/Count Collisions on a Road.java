// ********************************************************** Java ***********************************************************************

// T.C: O(N)
// S.C: O(1)
class Solution {
    public int countCollisions(String directions) {
        int collision = 0;
        int n = directions.length();
        int i=0, j=n-1;

        while(i<n&& directions.charAt(i)=='L'){
            i++;
        }

        while(j>=0 && directions.charAt(j)=='R'){
            j--;
        }

        while(i<=j){
            char dir = directions.charAt(i);
            if(dir!='S'){
                collision++;
            }
            i++;
        }

        return collision;
    }
}


// ********************************************************** C++ ***********************************************************************

// T.C: O(N)
// S.C: O(1)
class Solution {
public:
    int countCollisions(string directions) {
        int n = directions.size();
        int collision = 0;

        int i = 0;
        while(i<n && directions[i]=='L'){
            i++;
        }

        int j = n-1;
        while(j>=0 && directions[j]=='R'){
            j--;
        }

        while(i<=j){
            if(directions[i]!='S'){
                collision++;
            }
            i++;
        }

        return collision;
    }
};
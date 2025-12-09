// *********************************************************************************** JAVA *********************************************************************************

// T.C: O(nlogn + mlogm + min(n,m));
// S.C: O(1)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        int i=0,j=0;

        Arrays.sort(s);
        Arrays.sort(g);

        while(i<n && j<m){
            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }

        return i;
    }
}


// *********************************************************************************** C++ *********************************************************************************

// T.C: O(nlogn + mlogm + min(n,m));
// S.C: O(1)
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        int n = g.size();
        int m = s.size();
        int i=0,j=0;

        sort(g.begin(),g.end());
        sort(s.begin(),s.end());

        while(i<n&&j<m){
            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }
        return i;
    }
};
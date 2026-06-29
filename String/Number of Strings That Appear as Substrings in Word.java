// T.C: O(n*m)
// S.C: O(1)
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int cnt = 0;

        for(String pattern : patterns){
            if(word.contains(pattern)){
                cnt++;
            }
        }

        return cnt;
    }
}

// Approach: 2 (Knuth-Morris-Pratt KMP String Matching Algorithm)
// T.C: O(n*m)
// S.C: O(m)
class Solution {

    void computeLPS(String pattern, int[] lps) {
        int M = pattern.length();
        int len = 0;
        lps[0] = 0;

        int i = 1;
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    List<Integer> search(String pat, String txt) {
        int N = txt.length();
        int M = pat.length();
        List<Integer> result = new ArrayList<>();

        int[] lps = new int[M];
        computeLPS(pat, lps);

        int i = 0, j = 0;
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == M) {
                result.add(i - j + 1);
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }

        }
        return result;
    }

    public int numOfStrings(String[] patterns, String word) {
        int cnt = 0;

        for (String pattern : patterns) {
            if (search(pattern, word).size() > 0) {
                cnt++;
            }
        }

        return cnt;
    }
}
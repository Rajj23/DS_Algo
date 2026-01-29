//Approach-1 (Using Simple Floyd Warshall Algorithm)
//T.C : O(n)  -> Because other for loops run only for constant time 26*26*26
//S.C : O(1) -> We take distances matrix of 26*26 which is constant
class Solution {
    void FloydWarshal(long[][] adjMatrix, char[] original, char[] changed, int[] cost){

        for(int i = 0; i < original.length; i++){
            int s = original[i] - 'a';
            int t = changed[i] - 'a';

            adjMatrix[s][t] = Math.min(adjMatrix[s][t], (long)cost[i]);
        }

        for(int k = 0; k < 26; k++){
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 26; j++){
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], 
                    adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }        
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = original.length;
        long[][] adjMatrix = new long[26][26];

        for(int i = 0; i < 26; i++){
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
        }

        FloydWarshal(adjMatrix, original, changed, cost);

        long totalCost = 0;

        int m = source.length();
        for(int i = 0; i < m; i++){
            int src = source.charAt(i) - 'a';
            int tar = target.charAt(i) - 'a';

            if(src == tar){
                continue;
            }

            if(adjMatrix[src][tar] == Integer.MAX_VALUE){
                return -1;
            }
            totalCost += adjMatrix[src][tar];
        }

        return totalCost;
    }
}
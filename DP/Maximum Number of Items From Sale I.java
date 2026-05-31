// T.C: O(n*n)
// S.C: O(n*n)
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] frees = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && items[j][0] % items[i][0] == 0){
                    frees[i]++;
                }
            }
        }

        int[] t = new int[budget+1];
        Arrays.fill(t, -1);
        t[0] = 0;

        for(int i = 0; i < n; i++){
            int price = items[i][1];
            int free = frees[i];

            int[] temp = new int[budget+1];
            Arrays.fill(temp, -1);
            for(int j = price; j <= budget; j++){
                if(t[j-price] != -1){
                    temp[j] = t[j-price] + 1 + free;
                }
            }

            for(int j = price; j <= budget; j++){
                if(temp[j-price] != -1){
                    int copy = temp[j - price] + 1;
                    if(temp[j] == -1 || copy > temp[j]){
                        temp[j] = copy;
                    }
                }
            }

            for(int j = 0; j <= budget; j++){
                if(temp[j] != -1 && temp[j] > t[j]){
                    t[j] = temp[j];
                }
            }
        }

        int result = 0;
        for(int j = 0; j <= budget; j++){
            if(t[j] != -1){
                result = Math.max(result, t[j]);
            }
        }

        return result;
    }
}
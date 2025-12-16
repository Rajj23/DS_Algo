//Approach (DFS + Recursion)
//T.C : O(n * budget^2)
//S.C : O(n * budget)
class Solution {

    private void dfs(
        int u, int[] present, int[] future, List<Integer>[] adj,int[][][] statesProfit, int budget
    ){
        List<int[][]> childrenStatesProfit = new ArrayList<>();

        for(int v: adj[u]){
            dfs(v,present,future,adj,statesProfit,budget);
            childrenStatesProfit.add(
                new int[][] {statesProfit[v][0], statesProfit[v][1]}
            );
        }

        for(int parentBought = 0; parentBought <= 1; parentBought++){
            int price = (parentBought==1) ? present[u]/2 : present[u];
            int profit = future[u] - price;

            int[] bestProfitAtU = new int[budget + 1];

            // Case 1 : Do not buy node u

            int[] childrenProfitIfNotBought = new int[budget + 1];

            for(int[][] child : childrenStatesProfit){
                int[] childNoBuy = child[0];
                int[] temp = new int[budget + 1];

                for(int used = 0;used<=budget;used++){
                    for(int take=0;used+take<=budget;take++){
                        temp[used+take] = Math.max(
                            temp[used+take],
                            childrenProfitIfNotBought[used] + childNoBuy[take]
                        );
                    }
                }
                childrenProfitIfNotBought = temp;
            }

            for(int b=0;b<=budget;b++){
                bestProfitAtU[b] = Math.max(bestProfitAtU[b], childrenProfitIfNotBought[b]);
            }
            // case 2: Buy node u
            if(price <= budget){
                int[] childrenProfitIfUBought = new int[budget + 1];

                for(int[][] child:childrenStatesProfit){
                    int[] childBuy = child[1];
                    int[] temp = new int[budget + 1];
                    
                    for(int used=0;used<=budget;used++){
                        for(int take=0;used+take<=budget;take++){
                            temp[used+take] = Math.max(
                                temp[used + take],
                                childrenProfitIfUBought[used] + childBuy[take]
                            );
                        }
                    }
                    childrenProfitIfUBought = temp;
                }
                for(int b=price;b<=budget;b++){
                    bestProfitAtU[b] = Math.max(
                        bestProfitAtU[b],
                        childrenProfitIfUBought[b-price] + profit
                    );
                }
            }
            statesProfit[u][parentBought] = bestProfitAtU;
        }
    }

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {

        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] h:hierarchy){
            int u = h[0] - 1;
            int v = h[1] - 1;
            adj[u].add(v);
        }

        int[][][] statesProfit = new int[n][2][budget+1];

        dfs(0,present,future,adj,statesProfit,budget);

        int ans = 0;
        for(int b=0;b<=budget;b++){
            ans = Math.max(ans, statesProfit[0][0][b]);
        }

        return ans;
    }
}
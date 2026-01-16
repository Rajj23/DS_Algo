//T.C : O(h^2 + v^2 + hlogh + vlogv), h = hFences.size(), v = vFences.size()
//S.C : O(h+v)
class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int M = 1_000_000_007;

        List<Integer> hList = new ArrayList<>();
        List<Integer> vList = new ArrayList<>();

        for(int hFence : hFences){
            hList.add(hFence);
        }
        for(int vFence : vFences){
            vList.add(vFence);
        }

        hList.add(1);
        hList.add(m);

        vList.add(1);
        vList.add(n);

        Collections.sort(hList);
        Collections.sort(vList);

        Set<Integer> widths = new HashSet<>();

        for(int i = 0; i < vList.size(); i++){
            for(int j = i+1; j < vList.size(); j++){
                int width = vList.get(j) - vList.get(i);
                widths.add(width);
            }
        }
        
        int maxSize = 0;
        for(int i = 0; i < hList.size(); i++){
            for(int j = i+1; j < hList.size(); j++){
                int height = hList.get(j) - hList.get(i);
                
                if(widths.contains(height)){
                    maxSize = Math.max(maxSize, height);
                }
            }
        }
        long result = (long)maxSize * maxSize;

        return maxSize == 0 ? -1 : (int) (result % M);
    }
}
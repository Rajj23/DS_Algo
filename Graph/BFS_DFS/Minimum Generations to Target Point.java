// T.C: O(N^3)
// S.C: O(N)
class Solution {
    boolean isSame(int[] a, int[] b){
        return a[0] == b[0] &&
            a[1] == b[1] &&
            a[2] == b[2];
    }
    
    public int minGenerations(int[][] points, int[] target) {
        int n = points.length;

        List<int[]> p = new ArrayList<>();
        Set<String> st = new HashSet<>();
        
        for(int[] point : points){
            p.add(point);
            String key = point[0] + "_" + point[1] + "_" + point[2];
            st.add(key);
            if(isSame(point, target)) return 0;
        }
        
        int ans = 0;


        while(true){
            int size = p.size();
            int curr = 0;

            List<int[]> temp = new ArrayList<>();

            for(int i = 0; i < size; i++){
                for(int j = i+1; j < size; j++){
                    int[] a = p.get(i);
                    int[] b = p.get(j);

                    int x = (a[0] + b[0])/2;
                    int y = (a[1] + b[1])/2;
                    int z = (a[2] + b[2])/2;

                    int[] mid = {x, y, z};
                    String key = x + "_" + y + "_" + z;

                    if(!st.contains(key)){
                        st.add(key);
                        temp.add(mid);
                        curr++;

                        if(isSame(mid, target)){
                            return ans+1;
                        }
                    }
                }
            }
            if(curr == 0) return -1;
            p.addAll(temp);
            ans++;
        }
    }
}
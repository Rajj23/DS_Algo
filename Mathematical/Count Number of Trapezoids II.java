// T.C: O(N*N)
// S.C: O(N)
class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        double INF = 1e9 + 7;

        Map<Double,List<Double>> slopeIntercpts = new HashMap<>();
        Map<Integer, List<Double>> midPointMap = new HashMap<>();
        int result = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int dx = x1-x2;
                int dy = y1-y2;

                double slope, intercept;
                if(x1==x2){
                    slope = INF;
                    intercept = x1;
                }
                else{
                    slope = 1.0*(y2-y1)/(x2-x1);
                    intercept = 1.0*(y1*dx -x1*dy)/dx;
                }

                if (slope == -0.0) slope = 0.0;
                if (intercept == -0.0) intercept = 0.0;

                int midPointKey = (x1+x2)*10000 + (y1+y2);

                slopeIntercpts.computeIfAbsent(slope,k-> new ArrayList<>()).add(intercept);
                midPointMap.computeIfAbsent(midPointKey, k-> new ArrayList<>()).add(slope);
            }
        }
        for(List<Double> interceptList : slopeIntercpts.values()){
            if(interceptList.size()<=1) continue;

            Map<Double,Integer> mp = new TreeMap<>();

            for(double intercept : interceptList){
                mp.put(intercept,mp.getOrDefault(intercept,0)+1);
            }

            int prevHorizLines = 0;
            for(int count:mp.values()){
                result +=count * prevHorizLines;

                prevHorizLines += count;
            }
        }

        for(List<Double> slopeList : midPointMap.values()){
            if(slopeList.size()<=1) continue;
            Map<Double,Integer> mp = new TreeMap<>();

            for(double slope : slopeList){
                mp.put(slope,mp.getOrDefault(slope,0)+1);
            }

            int prevHorizLines = 0;
            for(int count:mp.values()){
                result -=count * prevHorizLines;

                prevHorizLines += count;
            }
        }
        return result;
    }
}
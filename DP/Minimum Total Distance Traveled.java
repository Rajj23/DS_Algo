//T.C : O(R log R + F log F + R * F * C)
//S.C : O(R * F * C)
class Solution {
    long[][][] t;
    long solve(int idxRob, int postFac, int facCap, List<Integer> robot, int[][] factory){
        if(idxRob >= robot.size()) return 0;
        if(postFac >= factory.length) return Long.MAX_VALUE/2;

        if(t[idxRob][postFac][facCap] != -1){
            return t[idxRob][postFac][facCap];
        }

        long costPick = Long.MAX_VALUE/2;
        if(facCap > 0){
            facCap--;
            costPick = Math.abs(robot.get(idxRob) - factory[postFac][0]) + 
                solve(idxRob+1, postFac, facCap, robot, factory);
            facCap++;
        }

        long costNotPick = Long.MAX_VALUE/2;
        if(postFac+1 < factory.length){
            costNotPick = solve(idxRob, postFac+1, factory[postFac+1][1], robot, factory);
        }

        return t[idxRob][postFac][facCap] = Math.min(costPick, costNotPick);

    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a,b) -> Integer.compare(a[0], b[0]));

        t = new long[101][101][101];
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++)
                Arrays.fill(t[i][j], -1);
        }

        return solve(0, 0, factory[0][1], robot, factory);
    }
}


//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    long[][]t;
    long solve(int idxRob, int postFac, List<Integer> robot, List<Integer> factory){
        if(idxRob >= robot.size()) return 0;
        if(postFac >= factory.size()) return Long.MAX_VALUE/2;

        if(t[idxRob][postFac] != -1){
            return t[idxRob][postFac];
        }

        long costPick = Math.abs(robot.get(idxRob) - factory.get(postFac)) + 
            solve(idxRob+1, postFac+1, robot, factory);

        long costNotPick = solve(idxRob, postFac+1, robot, factory);

        return t[idxRob][postFac] = Math.min(costPick, costNotPick);

    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a,b) -> Integer.compare(a[0], b[0]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < factory.length; i++){
            int post = factory[i][0];
            int limit = factory[i][1];

            for(int j = 0; j < limit; j++){
                list.add(post);
            }
        }

        t = new long[101][list.size()+1];
        for(int i = 0; i < 101; i++){
            Arrays.fill(t[i], -1);
        }

        return solve(0, 0, robot, list);
    }
}
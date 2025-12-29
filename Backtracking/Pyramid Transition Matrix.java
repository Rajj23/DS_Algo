//Approach (Khandani Backtracking template -> all possible options)
//T.C : ~(L^n) , L = maximum count of top characters available for each pairs in allowed, n = bottom.length()
//S.C : O(n^2) recursion stack can go at most n levels deep, and at each level you keep a partially built row of length ≤ n, so the total stack memory is O(n × n) = O(n²).
class Solution {
    Map<String, Boolean> t = new HashMap<>();
    boolean solve(String curr, Map<String,List<Character>> mp, int idx, StringBuilder above){
        if(curr.length()==1) return true;

        String key = curr + "_" + idx +"_" + above;

        if(t.containsKey(key)) return t.get(key);

        if(idx == curr.length()-1){
            t.put(key, solve(above.toString(),mp,0, new StringBuilder()));
            return t.get(key);
        }

        String pair = curr.substring(idx,idx+2);
        if(!mp.containsKey(pair)){
            t.put(key,false);
            return t.get(key);
        } 

        for(char ch:mp.get(pair)){
            above.append(ch);
            
            if(solve(curr,mp,idx+1,above)==true){
                t.put(key,true);
                return t.get(key);
            } 

            above.deleteCharAt(above.length()-1);
        }

        t.put(key,false);
        return t.get(key);
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String,List<Character>> mp = new HashMap<>();

        for(String pattern:allowed){
            String pair = pattern.substring(0,2);
            char top = pattern.charAt(2);
            mp.computeIfAbsent(pair, k-> new ArrayList<>()).add(top);
        }

        return solve(bottom,mp,0, new StringBuilder());
    }
}
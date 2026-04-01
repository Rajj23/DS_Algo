// T.C: O(n log n) — due to TreeMap sorting
// S.C: O(n) — stack + survive list
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> mp = new TreeMap<>();
        int i = 0;
        for(int pos : positions){
            mp.put(pos, i++);
        }

        Stack<Integer> st = new Stack<>();
        List<Integer> survive = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int pos = entry.getKey();
            int idx = entry.getValue();
            int health = healths[idx];

            if(directions.charAt(idx) == 'R'){
                st.add(idx);
            }
            else{
                while(!st.isEmpty() && healths[idx] > 0){
                    if(healths[st.peek()] == healths[idx]){
                        healths[idx] = 0;
                        st.pop();
                        break;
                    }
                    else if(healths[st.peek()] > healths[idx]){
                        healths[idx] = 0;
                        healths[st.peek()]--;
                        break;
                    }
                    else{
                        healths[idx]--;
                    }
                    st.pop();
                }
                if(healths[idx] > 0) survive.add(idx);
            }
        }

        while(!st.isEmpty()){
            survive.add(st.pop());
        }

        Collections.sort(survive);

        for(int surv : survive){
            result.add(healths[surv]);
        }

        return result;
    }
}


//Using Stack
//T.C : O(nlogn)
//T.C : O(n)
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> result = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        Integer[] indices = new Integer[positions.length];
        for(int i = 0; i < positions.length; i++) indices[i] = i;
        
        Arrays.sort(indices, (a,b) -> positions[a] - positions[b]);

        for(int idx : indices){

            if(directions.charAt(idx) == 'R'){
                st.add(idx);
            }
            else{
                while(!st.isEmpty() && healths[idx] > 0){
                    if(healths[st.peek()] == healths[idx]){
                        healths[idx] = 0;
                        healths[st.peek()] = 0;
                        st.pop();
                        break;
                    }
                    else if(healths[st.peek()] > healths[idx]){
                        healths[idx] = 0;
                        healths[st.peek()]--;
                        break;
                    }
                    else{
                        healths[idx]--;
                        healths[st.peek()] = 0;
                        st.pop();
                    }
                }
                
            }
        }
        
        for(int i = 0; i < positions.length; i++){
            if(healths[i] > 0){
                result.add(healths[i]);
            }
        }

        return result;
    }
}
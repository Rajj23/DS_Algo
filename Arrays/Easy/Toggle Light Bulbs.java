// T.C: O(n)
// S.C: O(n)
class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        Set<Integer> st = new HashSet<>();

        for(int i = 0; i < bulbs.size(); i++){
            int bulb = bulbs.get(i);
            if(st.contains(bulb)){
                st.remove(bulb);
            }
            else{
                st.add(bulb);
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int s : st){
            result.add(s);
        }
        Collections.sort(result);
        return result;
    }
}
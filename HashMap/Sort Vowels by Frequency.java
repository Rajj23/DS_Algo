// T.C: O(nlogn)
// S.C: O(n)
class Solution {
    public String sortVowels(String s) {
        int n = s.length();

        Set<Character> st = new HashSet<>();
        st.add('a');
        st.add('e');
        st.add('i');
        st.add('o');
        st.add('u');
        
        Map<Character, Integer> mp = new HashMap<>();
        Map<Character, Integer> firstIdx = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int i = 0;
        for(char ch : s.toCharArray()){
            if(st.contains(ch)){
                mp.put(ch, mp.getOrDefault(ch, 0)+1);
                list.add(i);

                firstIdx.putIfAbsent(ch, i);
            }
            i++;
        }

        List<Character> sorted = new ArrayList<>(mp.keySet());

        sorted.sort((a, b)->{
            if(!mp.get(a).equals(mp.get(b))){
                return mp.get(b) - mp.get(a);
            }
            return firstIdx.get(a) - firstIdx.get(b);
        });

        List<Character> built = new ArrayList<>();
        for(char ch : sorted){
            int freq = mp.get(ch);
            while(freq > 0){
                built.add(ch);
                freq--;
            }
        }

        char[] ch = s.toCharArray();

        i = 0;
        for(int idx : list){
            ch[idx] = built.get(i++);
        }

        return new String(ch);
    }
}
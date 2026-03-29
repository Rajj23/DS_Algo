// T.C: O(1)
// S.C: O(1)
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);

        for(int i = 0; i < 4; i++){
            if(sb1.charAt(i) != sb2.charAt(i)){
                if(i+2 < 4){
                    char temp = sb1.charAt(i);
                    sb1.setCharAt(i, sb1.charAt(i+2));
                    sb1.setCharAt(i+2, temp);
                }
                if(sb1.charAt(i) != sb2.charAt(i)) return false;
            }
        }
        return true;
    }
}

// T.C: O(1)
// S.C: O(1)
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int[] even = new int[26];
        int[] odd = new int[26];

        for(int i = 0;i < 4; i++){
            if(i%2 == 0){
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            }
            else{
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }

        for(int i = 0; i < 26; i++){
            if(even[i] != 0) return false;
            if(odd[i] != 0) return false;
        }

        return true;
    }
}
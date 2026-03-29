// T.C: O(n*n)
// S.C: O(2n)
class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();

        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        for(int i = 0; i < n; i++){
            if(ch1[i] != ch2[i]){
                for(int j = i; j < n; j+=2){
                    if(ch1[j] == ch2[i]){
                        char temp = ch1[i];
                        ch1[i] = ch1[j];
                        ch1[j] = temp;
                        break;
                    }
                }
                if(ch1[i] != ch2[i]) return false;
            }
        }

        return true;
    }
}

// T.C: O(nlogn)
// S.C: O(2n)
class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        char[] even1 = new char[n/2 + 1];
        char[] odd1 = new char[n/2 + 1];
        char[] even2 = new char[n/2 + 1];
        char[] odd2 = new char[n/2 + 1];

        int even = 0;
        int odd = 0;
        for(int i = 0; i < n; i++){
            if(i%2 == 0){
                even1[even] = s1.charAt(i);
                even2[even] = s2.charAt(i);
                even++;
            }
            else{
                odd1[odd] = s1.charAt(i);
                odd2[odd] = s2.charAt(i);
                odd++;
            }
        }

        Arrays.sort(even1);
        Arrays.sort(even2);
        Arrays.sort(odd1);
        Arrays.sort(odd2);

        for(int i = 0; i < n/2+1; i++){
            if(even1[i] != even2[i]) return false;
            if(odd1[i] != odd2[i]) return false;
        }

        return true;
    }
}


// T.C: O(n)
// S.C: O(1)
class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] even = new int[26];
        int[] odd = new int[26];

        for(int i = 0; i < s1.length(); i++){
            if(i % 2 == 0){
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            }
            else{
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }

        for(int i = 0; i < 26; i++){
            if(even[i] != 0 || odd[i] != 0) return false;
        }

        return true;
    }
}
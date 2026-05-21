// Approach 1 - Brute Force
// T.C : O(m⋅log10​M + n⋅log10​N)
// S.C : O(m⋅log10​M)
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> st = new HashSet<>();

        for(int val : arr1){
            while(!st.contains(val) && val > 0){
                st.add(val);
                val /= 10;
            }
        }

        int ans = 0;

        for(int val : arr2){
            int len = String.valueOf(val).length();
            while(val > 0){
                if(st.contains(val)){
                    ans = Math.max(ans, len);
                    break;
                }

                len--;
                val /= 10;
            }
        }

        return ans;
    }
}

//Approach 2 - Using Prefix Tree (TRIE)
//T.C : O(m⋅d+n⋅d)
//S.C : O(m⋅d)
class TrieNode{
    TrieNode[] children = new TrieNode[10];
}
class Solution {
    TrieNode getTrieNode(){
        return new TrieNode();
    }

    void insert(int num, TrieNode root){
        TrieNode crawl = root;
        String numStr = Integer.toString(num);

        for(char ch : numStr.toCharArray()){
            int idx = ch - '0';

            if(crawl.children[idx] == null){
                crawl.children[idx] = getTrieNode();
            }
            crawl = crawl.children[idx];
        }
    }

    int search(int num , TrieNode root){
        TrieNode crawl = root;
        String numStr = Integer.toString(num);
        int length = 0;

        for(char ch : numStr.toCharArray()){
            int idx = ch - '0';
            if(crawl.children[idx] != null){
                length++;
                crawl = crawl.children[idx];
            }
            else{
                break;
            }
        }
        return length;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = getTrieNode();

        for(int num : arr1){
            insert(num, root);
        }

        int result = 0;
        for(int num : arr2){
            result = Math.max(result, search(num, root));
        }

        return result;
    }
}
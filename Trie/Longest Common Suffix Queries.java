//T.C : Assuming m is the total number of characters in all words in wordsContainer, the time complexity of the insertTrie method is O(m).
//      Assuming n is the average length of words in wordsQuery, the time complexity of the search method is O(n).
//      T.C for stringIndices can be represented as O(m + n), where m is the total number of characters in wordsContainer and n is the average length of words in wordsQuery.
//S.C : Each node in the trie has an array of 26 pointers (assuming only lowercase English alphabets), 
//      resulting in a space complexity of O(26 * m) for storing all characters of words in wordsContainer. m = total number of characters in all words in wordsContainer.
class Solution {
    class TrieNode{
        int idx;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode getNode(int idx){
        TrieNode temp = new TrieNode();
        temp.idx = idx;

        for(int i = 0; i < 26; i++){
            temp.children[i] = null;
        }

        return temp;
    }

    void insertTrie(TrieNode root, int i, String[] wordsContainer){
        String word = wordsContainer[i];
        int n = word.length();

        for(int j = n-1; j >= 0; j--){

            char ch = word.charAt(j);
            int ch_idx = ch - 'a';

            if(root.children[ch_idx] == null){
                root.children[ch_idx] = getNode(i);
            }

            root = root.children[ch_idx];

            if(wordsContainer[root.idx].length() > n){
                root.idx = i;
            }
        }
    }

    int searchTrie(TrieNode root, String word){
        int result_idx = root.idx;
        int n = word.length();

        for(int i = n-1; i >= 0; i--){
            int ch_idx = word.charAt(i) - 'a';

            root = root.children[ch_idx];
            if(root == null){
                return result_idx;
            }

            result_idx = root.idx;
        }
        return result_idx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int m = wordsContainer.length;
        int n = wordsQuery.length;

        int[] result = new int[n];

        TrieNode root = getNode(0);

        for(int i = 0; i < m; i++){

            int idx = root.idx;
            if(wordsContainer[idx].length() > wordsContainer[i].length()){
                root.idx = i;
            }

            insertTrie(root, i, wordsContainer);
        }

        for(int i = 0; i < n; i++){
            result[i] = searchTrie(root, wordsQuery[i]);
        }

        return result;
    }
}
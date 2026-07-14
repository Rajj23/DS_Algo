// Approach: 2
// T.C: O(2n)
// S.C: O(n)
class Solution {
    Map<Integer, Integer> mp = new HashMap<>();

    void solve(TreeNode root){
        if(root == null) return;

        mp.put(root.val, mp.getOrDefault(root.val, 0) + 1);

        solve(root.left);
        solve(root.right);
    }

    public int[] findMode(TreeNode root) {
        if(root == null) return new int[]{};

        solve(root);

        List<Integer> list = new ArrayList<>();

        int maxFreq = 0;
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();

            if(maxFreq < freq){
                maxFreq = freq;

                list.clear();
                list.add(num);
            }
            else if(maxFreq == freq){
                list.add(num);
            }
        }

        int[] ans = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}


// Approach: 2
// T.C: O(n)
// S.C: O(1)
class Solution {
    List<Integer> list = new ArrayList<>();
    int maxFreq = 0;
    int currNum = 0;
    int currFreq = 0;

    void solve(TreeNode root){
        if(root == null) return;

        solve(root.left);
        int num = root.val;
        if(num == currNum){
            currFreq++;
        }
        else{
            currFreq = 1;
            currNum = num;
        }

        if(currFreq > maxFreq){
            maxFreq = currFreq;
            list = new ArrayList<>();
        }

        if(currFreq == maxFreq){
            list.add(num);
        }

        solve(root.right);
    }

    public int[] findMode(TreeNode root) {
        if(root == null) return new int[]{};
        solve(root);

        int[] result = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }
}
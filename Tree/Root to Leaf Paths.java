// T.C: O(n)
// S.C: O(H + L × H)
class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> subList = new ArrayList<>();
        preOrder(root,result,subList);
        
        return result;
    }
    
    private static void preOrder(Node root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subList){
        if(root==null){
            return;
        }
        
        subList.add(root.data);
        if(root.left == null && root.right == null){
            result.add(new ArrayList<>(subList));
        }
        else{
            preOrder(root.left, result,subList);
            preOrder(root.right,result,subList);
        }
        
        subList.remove(subList.size()-1);
    }
}
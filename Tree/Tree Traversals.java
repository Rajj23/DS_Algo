// Approach 1 (using seperate recursion)
// T.C: O(3n)
// S.C: O(3n)

import java.util.*;
import java.util.List;
public class Solution {

    static void pre(List<Integer> list,TreeNode root){
        if(root==null){
            return;
        }
        list.add(root.data);
        pre(list,root.left);
        pre(list,root.right);
    }

    static void in(List<Integer> list,TreeNode root){
        if(root==null){
            return;
        }
        in(list,root.left);
        list.add(root.data);
        in(list,root.right);
    }

    static void post(List<Integer> list,TreeNode root){
        if(root==null){
            return;
        }
        post(list,root.left);
        post(list,root.right);
        list.add(root.data);
    }

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> preOrder = new ArrayList<>();
        pre(preOrder,root);

        List<Integer> inOrder = new ArrayList<>();
        in(inOrder,root);

        List<Integer> postOrder = new ArrayList<>();
        post(postOrder,root);

        List<List<Integer>> result = new ArrayList<>();
        result.add(inOrder);
        result.add(preOrder);
        result.add(postOrder);

        return result;
    }
}


// Approach 2 (using 1 stack)
// T.C: O(3n)
// S.C: O(4n)
public class Solution {
    static class Pair{
        TreeNode root;
        int num;

        Pair(TreeNode root,int num){
            this.root = root;
            this.num = num;
        }
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        if(root==null){
            return result;
        }

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));

        while(!st.isEmpty()){
            Pair it = st.pop();

            if(it.num==1){
                preOrder.add(it.root.data);
                it.num++;
                st.push(it);

                if(it.root.left != null){
                    st.push(new Pair(it.root.left, 1));
                }
            }

            else if(it.num == 2){
                inOrder.add(it.root.data);
                it.num++;
                st.push(it);

                if(it.root.right != null){
                    st.push(new Pair(it.root.right, 1));
                }
            }

            else{
                postOrder.add(it.root.data);
            }
        }

        result.add(inOrder);
        result.add(preOrder);
        result.add(postOrder);
        
        return result;
    }
}
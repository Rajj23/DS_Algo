// T.C: O(1)
// S.C: O(n)
class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;

    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);

        if(min.isEmpty() || min.peek() >= val){
            min.push(val);
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;

        int val = st.pop();

        if(!min.isEmpty() && min.peek() == val){
            min.pop();
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;

        return st.peek();
    }
    
    public int getMin() {
        if(min.isEmpty()) return -1;
        return min.peek();
    }
}


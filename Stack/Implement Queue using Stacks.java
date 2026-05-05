// Approach: Transfer all element
// T.C: O(2n)
// S.C: O(2n)
class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }

        if(!st2.isEmpty()){
            int temp = st2.pop();
            while(!st2.isEmpty())
                st1.push(st2.pop());
            return temp;
        }
        else{
            return -1;
        }
    }
    
    public int peek() {
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }

        if(!st2.isEmpty()){
            int temp = st2.peek();
            while(!st2.isEmpty())
                st1.push(st2.pop());
            return temp;
        }
        else{
            return -1;
        }
    }
    
    public boolean empty() {
        return st1.isEmpty();
    }
}

// Approach: Lazzy Stack
// T.C: O(2n)
// S.C: O(2n)
class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }

        return st2.pop();
    }
    
    public int peek() {
        if(st2.isEmpty()){
            while(!st1.isEmpty())
                st2.push(st1.pop());
        }
        return st2.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}
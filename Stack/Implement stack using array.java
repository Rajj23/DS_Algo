// T.C: O(1)
// S.C: O(n)
class myStack {
    int[] arr;
    int top;
    int size = 0;
    public myStack(int n) {
        // Define Data Structures
        arr = new int[n];
        top = 0;
        size = n;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return top == 0;
    }

    public boolean isFull() {
        // check if the stack is full
        return top == size;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if(isFull()) return;
        arr[top] = x;
        top++;
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(isEmpty()) return;
        top--;
    }

    public int peek() {
        // Returns the top element of the stack
        if(isEmpty()) return -1;
        return arr[top-1];
    }
}
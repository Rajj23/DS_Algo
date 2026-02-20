// T.C: O(1)
// S.C: O(n)
class twoStacks {
    int[] arr;
    int top1;
    int top2;
    
    twoStacks() {
        arr = new int[101];
        top1 = 0;
        top2 = 100;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        // code here
        if(top1 > top2) return;
        arr[top1] = x;
        top1++;
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        if(top1 > top2) return;
        arr[top2] = x;
        top2--;
        // code here
    }

    // Function to remove an element from top of the stack1.
        
    int pop1() {
        // code here
        if(top1 == 0) return -1;
        
        return arr[--top1];
    }

        
    // Function to remove an element from top of the stack2.
    int pop2() {
        // code here
        if(top2 == 100) return -1;
        return arr[++top2];
    }
}
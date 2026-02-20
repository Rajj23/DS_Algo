// T.C: O(1)
// S.C: O(3n)
class kStacks {
    // main array to store elements
    
    private int[] arr;
    int[] top;
    int[] next;
    int freeslot;

    public kStacks(int n, int k) {
        // initialize data structures for k stacks
        arr = new int[n];
        next = new int[n];
        top = new int[k];
        
        Arrays.fill(top, -1);
        
        for(int i = 0; i < n-1; i++){
            next[i] = i+1;
        }
        next[n-1] = -1;
        freeslot = 0;
    }

    public void push(int x, int i) {
        // push element x into stack i
        if(freeslot == -1) return;
        
        int idx = freeslot;
        freeslot = next[freeslot];
        
        arr[idx] = x;
        
        next[idx] = top[i];
        top[i] = idx;
    }

    public int pop(int i) {
        // pop element from stack i
        
        if(top[i] == -1) return -1;
        
        int idx = top[i];
        top[i] = next[idx];
        
        int element = arr[idx];
        
        next[idx] = freeslot;
        freeslot = idx;
        
        return element;
    }
}
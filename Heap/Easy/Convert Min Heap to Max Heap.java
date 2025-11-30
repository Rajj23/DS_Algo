class Solution {
    
    static int parent(int i){
        return (i-1)/2;
    }
    
    static int left(int i){
        return (i*2)+1;
    }
    
    static int right(int i){
        return (i*2)+2;
    }
    
    
    static void heapify(int arr[],int i,int n){
        int largest = i;
        int l = left(i);
        int r = right(i);
        
        if(l<n && arr[l] > arr[largest]){
            largest = l;
        }
        if(r<n && arr[r] > arr[largest]){
            largest = r;
        }
        
        if(largest!=i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            heapify(arr,largest,n);
        }
        
    }
    
    
    static void convertMinToMaxHeap(int N, int arr[]) {
        // code here
        for(int i=N/2;i>=0;i--){
            heapify(arr,i,N);
        }
    }
}

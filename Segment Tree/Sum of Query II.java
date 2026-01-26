//T.C : O(q*log(n))
//S.C : O(4*n)
class Solution {
    int[] segTree;
    
    void buildTree(int idx, int l, int r, int[] arr){
        if(l == r){
            segTree[idx] = arr[l];
            return;
        }
        
        int mid = l + (r-l)/2;
        buildTree(2*idx+1, l, mid, arr);
        buildTree(2*idx+2, mid+1, r, arr);
        
        segTree[idx] = segTree[2*idx+1] + segTree[2*idx+2];
    }
    
    int queryUtil(int idx, int start, int end, int left, int right){
        if(start > right || end < left){
            return 0;
        }
        
        if(start <= left && right <= end){
            return segTree[idx];
        }
        
        int mid = left + (right - left)/2;
        return queryUtil(2*idx+1, start, end, left, mid) +
                queryUtil(2*idx+2, start, end, mid+1, right);
    }
    
    List<Integer> querySum(int n, int arr[], int q, int queries[]) {
        // code here
        segTree = new int[4*n];
        buildTree(0, 0, n-1, arr);
        
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 1;
        
        for(int k = 0; k < 2*q; k += 2){
            int l = queries[k] - 1;
            int r = queries[k+1] - 1;
            result.add(queryUtil(0, l, r, 0, n-1));
        }



        
        return result;
    }
}
class Solution {
    public int findMin(int n) {
        // code here
        int count = 0;
        
        // for 10 try
        count += n/10;
        n = n%10;
        
        // for 5 try
        count += n/5;
        n = n%5;
        
        // for 2 try
        count += n/2;
        n = n%2;
        
        // for 1 try
        count += n;
        
        return count;
        
    }
}

class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int rows = strs.length;
        int cols = strs[0].length();

        for(int c=0;c<cols;c++){
            for(int r=1;r<rows;r++){
                if(strs[r-1].charAt(c) > strs[r].charAt(c)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
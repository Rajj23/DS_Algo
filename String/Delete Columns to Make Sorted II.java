// T.C: O(2row*col)
// S.C: O(row)
class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();

        int deletion = 0;

        boolean[] alreadySorted = new boolean[rows];

        int row=0;
        int col=0;

        for(col=0;col<cols;col++){
            boolean deleted = false;

            for(row=0;row<rows-1;row++){
                if(!alreadySorted[row] && strs[row].charAt(col) > strs[row+1].charAt(col)){
                    deletion++;
                    deleted=true;
                    break;
                }
            }

            if(deleted){
                continue;
            }

            for(int i=0;i<rows-1;i++){
                alreadySorted[i] = alreadySorted[i] | (strs[i].charAt(col)<strs[i+1].charAt(col));
            }
        }

        return deletion;
    }
}
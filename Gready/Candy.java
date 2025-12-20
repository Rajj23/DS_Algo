// Approach 1
// T.C: O(3n)
// S.C: O(2n)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        right[n-1] = 1;

        for(int i=1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                left[i] = left[i-1]+1;
            }
            else{
                left[i] = 1;
            }
        }

        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                right[i] = right[i+1]+1;
            }
            else{
                right[i] = 1;
            }
        }

        int result = 0;
        for(int i=0;i<n;i++){
            result += Math.max(left[i],right[i]);
        }

        return result;
    }
}


// Approach 2
// T.C: O(2n)
// S.C: O(n)

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];

        left[0] = 1;

        for(int i=1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                left[i] = left[i-1]+1;
            }
            else{
                left[i] = 1;
            }
        }
        int right = 1, curr = 1;
        int result = Math.max(left[n-1], 1);

        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                curr = right+1;
                right = curr;
            }
            else{
                curr = 1;
                right = 1;
            }
            result += Math.max(left[i], curr);
        }

        return result;
    }
}

// Approach 3
// T.C: O(n)
// S.C: O(1)
class Solution {
    public int candy(int[] ratings){
        int n = ratings.length;
        int sum = 1;
        int i = 1;

        while(i<n){
            if(ratings[i]==ratings[i-1]){
                sum++;
                i++;
                continue;
            }

            int peak = 1;
            while(i<n && ratings[i]>ratings[i-1]){
                peak++;
                sum+=peak;
                i++;
            }

            int down = 1;
            while(i<n && ratings[i]<ratings[i-1]){
                sum+= down;
                down++;
                i++;
            }

            if(down>peak){
                sum+= (down - peak);
            }
        }
        return sum;
    }
}
//T.C : O(row*(col+col)) ~= O(row*col)
//S.C : O(col)
class Solution {
    int[] getNSR(int[] height){
        Stack<Integer> st = new Stack<>();

        int n = height.length;

        int[] NSR = new int[n];

        for(int i = n-1; i >= 0; i--){
            if(st.isEmpty()){
                NSR[i] = n;
            }
            else{
                while(!st.isEmpty() && height[st.peek()] >= height[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    NSR[i] = n;
                }
                else{
                    NSR[i] = st.peek();
                }
            }
            st.add(i);
        }
        return NSR;
    }

    int[] getNSL(int[] height){
        Stack<Integer> st = new Stack<>();

        int n = height.length;

        int[] NSL = new int[n];

        for(int i = 0; i <n; i++){
            if(st.isEmpty()){
                NSL[i] = -1;
            }
            else{
                while(!st.isEmpty() && height[st.peek()] >= height[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    NSL[i] = -1;
                }
                else{
                    NSL[i] = st.peek();
                }
            }
            st.add(i);
        }
        return NSL;
    }
    
    int findMaxArea(int[] height){
        // width - NSR[i] - NSL[i] - 1
        // height - height[i]

        int[] NSR = getNSR(height);
        int[] NSL = getNSL(height);

        int n = height.length;

        int[] width = new int[n];
        for(int i = 0; i < n; i++){
            width[i] = NSR[i] - NSL[i] - 1;
        }

        int maxArea = 0;

        for(int i = 0; i < n; i++){
            int a = width[i] * height[i];

            maxArea = Math.max(maxArea, a);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] height = new int[n];

        // Add the first row in the height - 1D
        for(int i = 0; i < n; i++){
            height[i] = (matrix[0][i] == '1') ? 1 : 0;
        }

        int maxArea = findMaxArea(height);

        for(int row = 1; row < m; row++){
            
            for(int col = 0; col < n; col++){

                if(matrix[row][col] == '0'){
                    height[col] = 0;
                }
                else{
                    height[col] += 1;
                }
            }
            maxArea = Math.max(maxArea, findMaxArea(height));
        }

        return maxArea;
    }
}
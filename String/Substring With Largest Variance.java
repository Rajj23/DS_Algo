// T.C: O(26*2*N)
// S.C: O(1)
class Solution {
    public int largestVariance(String s) {
        int[] count = new int[26];

        for(char ch:s.toCharArray()){
            count[ch-'a'] = 1;
        }
        int result = 0;

        for(char first='a';first<='z';first++){
            for(char second='a';second<='z';second++){
                if(count[first-'a']==0 || count[second-'a']==0) continue;
                
                int firstCount = 0;
                int secondCount = 0;

                boolean pastSecond = false;

                for(char ch:s.toCharArray()){
                    if(ch==first){
                        firstCount++;
                    }
                    if(ch==second){
                        secondCount++;
                    }

                    if(secondCount > 0){
                        result = Math.max(result,firstCount-secondCount);
                    }
                    else{
                        if(pastSecond){
                            result = Math.max(result, firstCount-1);
                        }
                    }

                    if(secondCount > firstCount){
                        secondCount =0;
                        firstCount = 0;
                        pastSecond = true;
                    }
                }
            }
        }
        return result;
    }
}
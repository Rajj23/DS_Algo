class Solution {
    public int minPartitions(String n) {
        char ans = '0';

        for(char ch : n.toCharArray()){
            if(ch > ans){
                ans = ch;
            }
        }

        return ans - '0';
    }
}


class Solution {
    public int minPartitions(String n) {
        int count = 0;

        char[] arr = n.toCharArray();

        while(true){
            boolean changed = false;

            for(int i = 0; i < arr.length; i++){
                if(arr[i] != '0'){
                    arr[i]--;
                    changed = true;
                }
            }

            if(!changed) break;

            count++;
        }

        return count;
    }
}
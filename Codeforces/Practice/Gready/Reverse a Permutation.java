import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();

            int[] nums = new int[n];

            for(int j = 0; j < n; j++){
                nums[j] = sc.nextInt();
            }
            
            int i = 0;
            while(i < n && nums[i] == n-i) i++;

            if(i < n){
                int target = n - i;
                int j = i;
                while(nums[j] != target) j++;

                int l = i, r = j;
                while(l < r){
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    l++;
                    r--;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < n; k++){
                if(k > 0) sb.append(" ");
                sb.append(nums[k]);
            }
            System.out.println(sb);
        }
    }
}
// Approach: 1
// T.C: O(n*log(n))
/// S.C: O(n)
class Solution {
    class Pair {
        int dis;
        int ele;

        Pair(int dis, int ele) {
            this.dis = dis;
            this.ele = ele;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.dis != b.dis)
                        return b.dis - a.dis;
                    return b.ele - a.ele;
                });

        for (int a : arr) {
            int dis = Math.abs(x - a);
            pq.add(new Pair(dis, a));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            list.add(pq.poll().ele);
        }
        Collections.sort(list);
        return list;
    }
}


// Approach: 2
// T.C: O(log(n))
// S.C: O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x){
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while(low <= high){
            mid = low + (high - low)/2;

           if(arr[mid] < x){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }

        int left = low - 1;
        int right = low;
        List<Integer> ans = new ArrayList<>();

        while(left >=0 && right < arr.length && k > 0){
            if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                ans.add(arr[left]);
                left--;
            }
            else{
                ans.add(arr[right]);
                right++;
            }
            k--;
        }
        
        while(left >= 0 && k > 0){
            ans.add(arr[left]);
            left--;
            k--;
        }

        while(right < arr.length && k > 0){
            ans.add(arr[right]);
            right++;
            k--;
        }

        Collections.sort(ans);
        return ans;

    }
}
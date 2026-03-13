// T.C: O((log T · (n + mountainHeight))
// S.C: O(1)
class Solution {
    boolean check(int mountainHeight, int[] workerTimes, long mid){
        int removed = 0;
        for(int i = 0; i < workerTimes.length; i++){
            int cost = workerTimes[i];
            long total = 0;

            long time = 1;

            while((time * cost) + total <= mid){
                total += (time * cost);
                removed++;
                time++;

                if(mountainHeight <= removed) return true;
            }
        }
        return false;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 0;
        long high = Long.MAX_VALUE;
        long result = 0;

        while(low <= high){
            long mid = low + (high - low)/2;

            if(check(mountainHeight, workerTimes, mid)){
                result = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return result;
    }
}


// T.C: O(n · log T) 
// S.C: O(1)
class Solution {
    boolean check(int mountainHeight, int[] workerTimes, long mid){
        long removed = 0;

        for(int t : workerTimes){
            long x = (2 * mid)/t;
            long k = (long) ((Math.sqrt(1 + 4.0 * x) - 1) / 2);

            removed += k;

            if(removed >= mountainHeight) return true;
        }

        return false;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 0;
        long high = Long.MAX_VALUE;
        long result = 0;

        while(low <= high){
            long mid = low + (high - low)/2;

            if(check(mountainHeight, workerTimes, mid)){
                result = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return result;
    }
}


// T.C: O(n · log T
// S.C: O(1)
class Solution {
    int maxElement(int[] workerTimes){
        int maxEle = -1;
        for(int time : workerTimes){
            maxEle = Math.max(maxEle, time);
        }
        return maxEle;
    }

    boolean check(long mid, int[] workerTimes, int mH){
        long h = 0;

        for(int t : workerTimes){
            h += (long)(Math.sqrt(2.0 * mid/t + 0.25) - 0.5);
            
            if(h >= mH) return true;
        }

        return h >= mH;

    }


    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes){
        int maxTime = maxElement(workerTimes);
        long l = 1;
        long r = (long) maxTime * mountainHeight * (mountainHeight+1)/2;

        long result = 0;

        while(l <= r){
            long mid = l + (r-l)/2;

            if(check(mid, workerTimes, mountainHeight)){
                result = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return result;
    }
}
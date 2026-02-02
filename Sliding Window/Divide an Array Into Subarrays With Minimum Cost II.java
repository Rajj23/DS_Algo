//Approach (Sliding Window using ordered sets)
//T.C : O(n * log(k)), set operations are logarithmic
//S.C : O(k), set stores (k-1) elements
class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        TreeSet<long[]> kMinimum = new TreeSet<>(
                (a, b) -> {
                    if (a[0] != b[0])
                        return Long.compare(a[0], b[0]); // compare values
                    return Long.compare(a[1], b[1]); // compare indices
                });
        TreeSet<long[]> remaining = new TreeSet<>(
                (a, b) -> {
                    if (a[0] != b[0])
                        return Long.compare(a[0], b[0]); // compare values
                    return Long.compare(a[1], b[1]); // compare indices
                });
        int n = nums.length;

        long sum = 0;

        int i = 1;
        while (i - dist < 1) {
            kMinimum.add(new long[] { nums[i], i });
            sum += nums[i];

            if (kMinimum.size() > k - 1) {
                long[] temp = kMinimum.pollLast();
                sum -= temp[0];
                remaining.add(temp);
            }

            i++;
        }
        long result = Long.MAX_VALUE;
        while (i < n) {
            kMinimum.add(new long[] { nums[i], i });
            sum += nums[i];

            if (kMinimum.size() > k - 1) {
                long[] temp = kMinimum.pollLast();
                sum -= temp[0];
                remaining.add(temp);
            }

            result = Math.min(result, sum);

            long[] remove = new long[] { nums[i - dist], i - dist };
            if (kMinimum.contains(remove)) {
                kMinimum.remove(remove);
                sum -= remove[0];

                if (!remaining.isEmpty()) {
                    long[] temp = remaining.pollFirst();
                    kMinimum.add(temp);
                    sum += temp[0];
                }
            } else {
                remaining.remove(remove);
            }
            i++;
        }

        return nums[0] + result;
    }
}
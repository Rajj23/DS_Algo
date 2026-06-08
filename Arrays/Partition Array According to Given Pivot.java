// T.C: O(n)
// S.C: O(n)
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];

        // small
        List<Integer> small = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for(int num : nums){
            if(num < pivot){
                small.add(num);
            }
            else if(num == pivot){
                equal.add(num);
            }
            else{
                greater.add(num);
            }
        }
        int i = 0;
        for(int num : small){
            result[i++] = num;
        }

        for(int num : equal){
            result[i++] = num;
        }

        for(int num : greater){
            result[i++] = num;
        }

        return result;
    }
}


// T.C: O(n)
// S.C: O(1)
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];

        // small
        int i = 0;
        for(int num : nums){
            if(num < pivot){
                result[i++] = num;
            }
        }

        // same
        for(int num : nums){
            if(num == pivot){
                result[i++] = num;
            }
        }

        // greater
        for(int num : nums){
            if(num > pivot){
                result[i++] = num;
            }
        }

        return result;
    }
}
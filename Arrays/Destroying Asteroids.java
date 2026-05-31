// T.C: O(n)
// S.C: O(1)
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long sum = mass;
        for(int asteroid : asteroids){
            if(sum >= asteroid){
                sum += asteroid;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
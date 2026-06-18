// T.C: O(1)
// S.C: O(1)
class Solution {
    public double angleClock(int hour, int minutes) {
       double hrAngle = 30*hour + 0.5*minutes;
       double minAngle = 6*minutes;

       double angle = Math.abs(hrAngle - minAngle);

       return Math.min(angle, 360-angle);
    }
}
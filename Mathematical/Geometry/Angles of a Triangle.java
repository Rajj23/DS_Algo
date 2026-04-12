// T.C: O(1)
// S.C: O(1)
class Solution {
    public double[] internalAngles(int[] sides) {
        int n = sides.length;

        double[] result = new double[n];
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];

        if(a+b > c && b+c > a && a+c > b){
            double agleA = Math.toDegrees(Math.acos((b*b + c*c - a*a) / (2.0*b*c)));
            double agleB = Math.toDegrees(Math.acos((-b*b + c*c + a*a) / (2.0*a*c)));
            double agleC = Math.toDegrees(Math.acos((b*b - c*c + a*a) / (2.0*a*b)));

            result[0] = agleA;
            result[1] = agleB;
            result[2] = agleC;
            Arrays.sort(result);
            return result;
        }
        else{
            return new double[0];
        }
    }
}
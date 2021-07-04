package leetcode.math.medium.powxN_50;

public class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0) return 0.0d;
        double res = 1;
        long k = n;
        if (k < 0) {
            k = -k;
        }
        while (k > 0) {
            if ((k & 1) == 1) {
                res = res * x;
            }
            x = x * x;
            k = k >> 1;
        }
        return n < 0 ? 1 / res : res;
    }
}

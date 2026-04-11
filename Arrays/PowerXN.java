class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;

        // Handle negative powers
        if (n < 0) {
            x = 1 / x;
           
            return powHelper(x, -(long)n);
        }

        return powHelper(x, n);
    }

    private double powHelper(double x, long n) {
        if (n == 0) return 1.0;
        double half = powHelper(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}

package may;

public class CountingBits {
    public int[] countBits(int num) {

        if (num<1) {
            return new int[]{0};
        }
        int dp[] = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
        int base = 1;
        for (int i = 1; i <= num; i++) {
            if(base*2 == i) {
                dp[i] = 1;
                base *= 2;
            } else {
                dp[i] = 1 + dp[i - base];
            }
        }
        return dp;
    }
}

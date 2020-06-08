package may;

public class UncrossedLines {

    public int maxUncrossedLines(int[] A, int[] B) {

        int dp[][] = new int[A.length+1][B.length+1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[A.length][B.length];

    }

    public int maxUncrossedLinesBruteForce(int[] A, int[] B) {

        return brute(A, B, 0, 0);

    }

    private int brute(int[] a, int[] b, int i, int j) {
        if (i>=a.length || j >= b.length) {
            return 0;
        }

        if (a[i] == b[j]) {
            return 1 + brute(a, b, i+1, j+1);
        }

        int s1 = brute(a, b, i+1, j);
        int s2 = brute(a, b, i, j+1);
        return Math.max(s1, s2);
    }


}

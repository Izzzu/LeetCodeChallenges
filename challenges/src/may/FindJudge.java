package may;

public class FindJudge {

    public int findJudge(int N, int[][] trust) {
        int[] trustArr = new int[N+1];
        for (int[] pair : trust) {
            trustArr[pair[0]]--;
            trustArr[pair[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (trustArr[i] == N-1) {
                return i;
            }
        }
        return -1;
    }

}

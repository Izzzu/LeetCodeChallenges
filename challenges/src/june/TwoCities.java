package june;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCities {
    public int twoCitySchedCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int n = costs.length/2;
        int A = 0;
        for (int i = 0; i<costs.length; i++) {
            A += costs[i][0];
        }

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return  (o2[0]-o2[1])- (o1[0]-o1[1]);
            }
        });

        int diff = 0;

        for (int i = 0; i<n; i++) {
            diff+=costs[i][0] - costs[i][1];
        }
        return A - diff;

    }
}

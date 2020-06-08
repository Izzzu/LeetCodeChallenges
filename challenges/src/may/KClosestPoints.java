package may;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPoints {

    public int[][] kClosest(int[][] points, int K) {

        if (K> points.length) {
            return null;
        }

        Arrays.sort(points, Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));

        return Arrays.copyOfRange(points, 0, K);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{-2,2}};
        System.out.println(new KClosestPoints().kClosest(arr, 1));
    }

}

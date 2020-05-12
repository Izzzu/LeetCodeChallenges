package may;

public class CheckIfStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {

        if (coordinates.length<2) {
            return false;
        }
        int x1 = coordinates[0][0];
        int x2 = coordinates[1][0];
        int y1 = coordinates[0][1];
        int y2 = coordinates[1][1];

        if (x1==x2) {
            for (int i = 0; i < coordinates.length; i++) {
                if (coordinates[i][0] != x1) {
                    return false;
                }
            }
            return true;
        }
        int a = 0;
        if (y1!= y2) {
            a = (y1-y2)/(x1-x2);
        }
        int b = y1-(a*x1);
        for (int i = 0; i < coordinates.length; i++) {

            if (coordinates[i][1] != a*coordinates[i][0] +b) {
                return false;
            }
        }

        return true;
    }
}

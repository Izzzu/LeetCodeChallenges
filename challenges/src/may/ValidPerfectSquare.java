package may;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {

        if (num == 1) {
            return true;
        }
        int start = 0;
        int end = num/2;
        while(start<=end) {
            int mid = start + (end-start)/2;

            double maybeSqr = (double)num / (double)mid;
            if (maybeSqr == mid) {
                return true;
            } else if (maybeSqr>mid) {
                start = mid+1;

            } else {
                end = mid-1;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(49));
    }
}



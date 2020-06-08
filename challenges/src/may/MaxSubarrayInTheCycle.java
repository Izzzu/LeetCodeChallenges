package may;

public class MaxSubarrayInTheCycle {

    public int maxSubarraySumCircular(int[] A) {

        int nonCircularMax = kadane(A);

        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
            A[i] = -A[i];
        }

        int currSum = total+ kadane(A);
        if (currSum<=0) {
            return nonCircularMax;
        }
        return Math.max(currSum, nonCircularMax);

    }

    private int kadane(int[] A) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

            for (int i = 0; i < A.length; i++) {
                if (maxEndingHere<0) {
                    maxEndingHere = 0;
                }
                maxEndingHere +=A[i];

                if (maxSoFar<maxEndingHere) {
                    maxSoFar = maxEndingHere;
                }

            }



        return maxSoFar;
    }

//    public int maxSubarraySumCircular(int[] A) {
//        int nonCircularSum = kadaneMaxSum(A);
//        int totalSum = 0;
//        for(int i=0;i<A.length;i++){
//            totalSum += A[i];
//            A[i] = -A[i];
//        }
//
//        int circularSum = totalSum + kadaneMaxSum(A);
//        if(circularSum<=0)
//            return nonCircularSum;
//        return Math.max(circularSum,nonCircularSum);
//    }
//
//    int kadaneMaxSum(int[] A){
//        int currentSum = A[0];
//        int maxSum = A[0];
//        for(int i=1;i<A.length;i++){
//            if(currentSum < 0)
//                currentSum = 0;
//            currentSum = A[i] + currentSum;
//            maxSum = Math.max(maxSum,currentSum);
//        }
//        return maxSum;
//    }

    public static void main(String[] args) {
        int[] arr = {-2,-3,-1};
        System.out.println(new MaxSubarrayInTheCycle().maxSubarraySumCircular(arr));
    }

}

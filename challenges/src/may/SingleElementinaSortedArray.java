package may;

public class SingleElementinaSortedArray {

    public int singleNonDuplicate(int[] nums) {

        if (nums.length%2==0) {
            throw new RuntimeException();
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length-1;
        int mid = start + (end-start)/2;
        while(start < end) {
            mid = start + (end-start)/2;

            if (mid%2==1) {
                if (nums[mid] == nums[mid-1]) {
                    start = mid+1;
                } else {
                    end = mid-1;

                }
            } else if (mid%2==0) {
                if (nums[mid] == nums[mid+1]) {
                    start = mid+2;
                } else {
                    end = mid;
                }
            }
        }
        return nums[start];
    }

    public int singleNonDuplicate2(int[] nums) {
        int lo = 0, len = nums.length, hi = len / 2;

        while (lo < hi){
            int mid = lo + ((hi - lo) >> 1);
            if (nums[2 * mid] == nums[2 * mid + 1]){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[2 * lo];

    }

    public int singleNonDuplicate3(int[] nums) {
        int xor = 0;
        for(int i=0;i<nums.length;i++)
        {
            xor = xor ^ nums[i];


        }
        return xor;


    }

    public static void main(String[] args) {

        int arr[] = new int[2*1000-1];

        int i =0;
        int j = 1;
        while(i<arr.length-1) {
            if(i==4324) {
                arr[i] = 4325;
                i++;
            } else {
                arr[i] = j;
                arr[i+1] = j;
                i +=2;
                j++;
            }
        }
        System.out.println(new SingleElementinaSortedArray().singleNonDuplicate(arr));
    }
}

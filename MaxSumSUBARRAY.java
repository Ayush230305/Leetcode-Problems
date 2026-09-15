public class MaxSumSUBARRAY {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int ele : nums){
            currSum += ele;
            maxSum = Math.max(maxSum,currSum);
            if(currSum < 0) currSum = 0;
        }
        return maxSum;
    }
}

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int currProd = 1;
        int maxProd = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            currProd *= nums[i];
            maxProd = Math.max(maxProd,currProd);
            if(currProd == 0) currProd = 1;
        }
        currProd = 1;
        for(int i = n -1 ; i > 0 ; i--){
            currProd *= nums[i];
            maxProd = Math.max(maxProd,currProd);
            if(currProd == 0) currProd = 1;
        }
        return maxProd;
    }
}
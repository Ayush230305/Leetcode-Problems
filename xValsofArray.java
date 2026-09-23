public class xValsofArray{
    class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] res = new long[k];
        long[] cnt = new long[k];
        for(int a : nums){
            long[] next = new long[k];
            int am = a % k;

            for(int r = 0 ; r < k ; r++){
                if(cnt[r] != 0){
                    next[(r * am) % k] += cnt[r]; 
                }
            }
            next[am]++;
            cnt = next;
            for (int r = 0; r < k; r++) {
                res[r] += cnt[r];
            }
        }
        return res;
    }
}
}

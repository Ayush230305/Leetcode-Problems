import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for (int num : nums) {
            Map<Integer, Integer> nxtdp = new HashMap<>();
            for (int sum : dp.keySet()) {
                int count = dp.get(sum);
                nxtdp.put(sum + num,nxtdp.getOrDefault(sum + num, 0) + count);
                nxtdp.put(sum - num,nxtdp.getOrDefault(sum - num, 0) + count);
            }
            dp = nxtdp;
        }
        return dp.getOrDefault(target, 0);
    }
}



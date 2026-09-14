public class CapacityOfShip {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = weights[0];
        for (int ele : weights) {
            sum += ele;
            max = Math.max(max, ele);
        }
        int lo = max, hi = sum, ans = sum;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(mid, weights, days)) {
                ans = mid;
                hi = mid - 1;
            } 
            else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    private static boolean canShip(int c, int[] weights, int d) {
        int cap = c;
        int days = 1;
        for (int ele : weights) {
            if (cap < ele) {
                days++;
                cap = c;
            }
            cap -= ele;
        }
        return days <= d;
    }
}

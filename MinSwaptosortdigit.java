import java.util.Arrays;

public class MinSwaptosortdigit {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] diSu = new int[n];
        Integer[] idx = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            diSu[i] = digiSum(nums[i]);
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> {
            if (diSu[a] != diSu[b]) return Integer.compare(diSu[a], diSu[b]);
            return Integer.compare(nums[a], nums[b]);
        });

        boolean[] visited = new boolean[n];   // added
        int cycles = 0;                       // added

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            cycles++;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = idx[j];
            }
        }
        return n - cycles;
    }

    private int digiSum(int x){
        int s = 0;
        while(x > 0){
            s += x % 10;
            x /= 10;
        }
        return s;
    }
}

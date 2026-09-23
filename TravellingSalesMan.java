import java.util.Arrays;

public class TravellingSalesMan {
    static final int INF = 100000000;
    static int n;
    static int[][] dist;
    static int[][] memo;
    static int[][] nextCity;

    static int tsp(int mask, int curr) {
        if (mask == (1 << n) - 1) {
            return dist[curr][0];
        }

        if (memo[mask][curr] != -1) {
            return memo[mask][curr];
        }

        int minCost = INF;
        int bestNext = -1;

        for (int next = 0; next < n; next++) {
            if ((mask & (1 << next)) == 0) {
                int cost = dist[curr][next] + tsp(mask | (1 << next), next);
                if (cost < minCost) {
                    minCost = cost;
                    bestNext = next;
                }
            }
        }

        nextCity[mask][curr] = bestNext;
        return memo[mask][curr] = minCost;
    }

    public static void main(String[] args) {
        dist = new int[][] {
            { 0, 10, 15, 20 },
            { 10, 0, 35, 25 },
            { 15, 35, 0, 30 },
            { 20, 25, 30, 0 }
        };

        n = dist.length;
        memo = new int[1 << n][n];
        nextCity = new int[1 << n][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int minCost = tsp(1, 0);

        System.out.println("Minimum Tour Cost: " + minCost);
        System.out.print("Path: 0");

        int curr = 0;
        int mask = 1;
        while (mask != (1 << n) - 1) {
            curr = nextCity[mask][curr];
            System.out.print(" -> " + curr);
            mask |= (1 << curr);
        }
        System.out.println(" -> 0");
    }
}
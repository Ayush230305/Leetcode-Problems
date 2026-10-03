import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WinandLoss {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> lostMap = new HashMap<>();
        for (int i = 0; i < matches.length; i++) {
            int loser = matches[i][1];
            lostMap.put(loser, lostMap.getOrDefault(loser, 0) + 1);
        }
        List<Integer> notLost = new ArrayList<>();
        List<Integer> lostOnce = new ArrayList<>();
        HashSet<Integer> players = new HashSet<>();
        for (int i = 0; i < matches.length; i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];
            players.add(winner);
            players.add(loser);
        }
        for (int player : players) {
            int losses = lostMap.getOrDefault(player, 0);
            if (losses == 0) {
                notLost.add(player);
            }
            if (losses == 1) {
                lostOnce.add(player);
            }
        }
        Collections.sort(lostOnce);
        Collections.sort(notLost);
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(notLost);
        answer.add(lostOnce);
        return answer;
    }
}
public static void main(String[] args) {
    WinandLoss solution = new WinandLoss();
    int[][] matches = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
    List<List<Integer>> result = solution.findWinners(matches);
    System.out.println(result);
}
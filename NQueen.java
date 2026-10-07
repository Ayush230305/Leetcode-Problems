import java.util.*;
public class NQueen {
    static int n;
    static boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col) return false;
            if (Math.abs(board[i] - col) == Math.abs(i - row)) return false;
        }
        return true;
    }
    static void solve(int[] board, int row) {
        if (row == n) {
            System.out.println(Arrays.toString(board));
            return;
        }
        for (int col = 1; col <= n; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col;
                solve(board, row + 1);
                board[row] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        n = sc.nextInt();
        int[] board = new int[n];
        solve(board, 0);
    }
}


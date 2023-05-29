import java.util.Arrays;
import java.util.Scanner;

public class NQueenProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int N = scanner.nextInt();

        int[][] board = new int[N][N];
        if (solveNQueens(board, 0)) {
            System.out.println("Solution exists!");
            printBoard(board);
        } else {
            System.out.println("No solution exists!");
        }

        scanner.close();
    }

    private static boolean solveNQueens(int[][] board, int row) {
        int N = board.length;

        if (row >= N) {
            return true; // All queens have been successfully placed
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // Place the queen

                if (solveNQueens(board, row + 1)) {
                    return true; // Queen placement is successful in the next r
                }

                board[row][col] = 0; // Backtrack and remove the queen
            }
        }

        return false; // Queen placement is not possible
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int N = board.length;

        // Check if there is a queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check if there is a queen in the upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check if there is a queen in the upper right diagonal
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true; // Safe to place a queen at the given position
    }

    private static void printBoard(int[][] board) {
        int N = board.length;

        for (int[] col : board) {
            for (int row : col) {
                System.out.print(row == 1 ? "Q" : " - ");
            }
            System.out.println();
        }
    }
}
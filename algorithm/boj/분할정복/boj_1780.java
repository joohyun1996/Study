package divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 1780

/**
 * 이전까지의 부분탐색 문제를 /2 가 아니라 /3의 경우 어떻게 풀 것인가 하는 문제
 */
public class dc3 {
    static int[][] board;
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        divide(0,0,n);

        System.out.printf(minus + "\n" + zero + "\n" + plus + "");
    }
    public static void divide(int row, int col, int n){
        if(chk(row, col, n)){
            if(board[row][col] == -1) minus++;
            else if(board[row][col] == 0) zero++;
            else plus++;

            return;
        }

        int k = n/3;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                divide(row + i * k, col + j * k, k);
            }
        }
    }

    public static boolean chk(int row, int col, int n){
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if(board[i][j] != board[row][col]){
                    return false;
                }
            }
        }
        return true;
    }
}

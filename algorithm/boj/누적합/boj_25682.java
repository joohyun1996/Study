package cumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 25682

/**
 * 배열의 누적합 을 구해 이차원 배열의 특정 부분의 최소 수정 갯수를 찾는 것
 * B,W
 * W,B 가 반복되어야 한다. 따라서 맨 처음 들어오는 값이 B면 0, 아니면 1로 계산하여 매번 B,W가 다르게 들어오는지 확인하고 같다면 0, 아니면 1을 이차원 배열에 저장한다.
 * 그리고 누적합을 이용하여 B로 시작하는 배열과 W로 시작하는 배열의 누적합을 따로 저장해주고, k*k 만큼의 누적합 배열의 값을 구해준다.
 * 그리고 white, black 배열의 누적합의 결괏값중 최솟값을 출력하면 된다.
 */
public class cs6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int k = Integer.parseInt(strs[2]);

        int[][] board = new int[n+1][m+1];
        int[][] sumB = new int[n+1][m+1];
        int[][] sumW = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            strs = br.readLine().split("");
            for (int j = 1; j <= m ; j++) {
                if((i+j) % 2 == 0){
                    board[i][j] = "B".equals(strs[j-1]) ? 0 : 1;
                }else{
                    board[i][j] = "B".equals(strs[j-1]) ? 1 : 0;
                }
                sumB[i][j] = sumB[i-1][j] + sumB[i][j-1] - sumB[i-1][j-1] + board[i][j];
                sumW[i][j] = sumW[i-1][j] + sumW[i][j-1] - sumW[i-1][j-1] + (1-board[i][j]);
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int black = sumB[i][j] - sumB[i][j-k] - sumB[i-k][j] + sumB[i-k][j-k];
                int white = sumW[i][j] - sumW[i][j-k] - sumW[i-k][j] + sumW[i-k][j-k];
                ans = Math.min(ans, Math.min(black,white));
            }
        }

        System.out.println(ans);
    }
}

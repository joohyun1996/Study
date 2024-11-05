package cumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 11660

/**
 * 이차원 배열의 누적합을 구하는 문제. 직접 누적합 배열을 그리면서 규칙을 찾아나가니 그렇게 어렵지 않았다.
 * 하지만 마지막 출력하는 부분에서 인덱스를 잘못 계산해 잠시 헤맨 문제.
 * 중복되는 부분 계산만 잘하면 된다.
 */
public class cs5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        int[][] arr = new int[n + 1][n + 1];
        long[][] sum = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            strs = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(strs[j - 1]);
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
            }
        }

        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;

        for (int i = 0; i < m; i++) {
            strs = br.readLine().split(" ");

            x1 = Integer.parseInt(strs[0]);
            y1 = Integer.parseInt(strs[1]);
            x2 = Integer.parseInt(strs[2]);
            y2 = Integer.parseInt(strs[3]);

            System.out.println(sum[x2][y2] - sum[x2][y1-1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1]);
        }
    }
}

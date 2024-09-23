package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 2156

/**
 * 이전에 풀었던 방식의 연장선 같은 문제.
 * dp[i][3]로 배열을 잡는다. 그리고 0(건너뜀), 1(처음 도착), 2(이전 배열에 도착) 의 상태로 관리한다.
 * 그때의 점화식은 Max(dp[i-1][0~2]), dp[i-1][0]+arr[i], dp[i-1][1] + arr[i] 의 순서로 도착한다.
 * 이때, dp[i][0]에서 모든 최댓값을 구하여야 했는데 [i][1], [i][2]의 값만 구해서 틀렸었던 문제 
 */
public class dp11 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        dp = new int[n+1][3];

        dp[1][1] = arr[1];
        for (int i = 2; i <=n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            dp[i][1] = dp[i-1][0] + arr[i];
            dp[i][2] = dp[i-1][1] + arr[i];
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            ans = Math.max(dp[n][i], ans);
        }

        System.out.println(ans);
    }
}

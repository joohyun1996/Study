package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 2579

/**
 * 보기와는 다르게 애먹은 문제
 * 3번 연속 계단을 타면 안된다 / 계단을 한번에 2칸 이동할 수 있다. 이 조건떄문에 머리가 아팠다.
 * 하지만 결국 dp[i][0] (이 계단 안씀), dp[i][1] (이 계단은 2칸 전에서 옴), dp[i][2] (이 계단은 1칸 전에서 옴 (연속))
 * 이 조건을 통해 점화식을 찾아 문제를 풀 수 있었다.
 * 하지만 마지막 계단을 밟아야만 한다. 따라서 dp[n][1], dp[n][2]중에 큰 값을 출력하면 된다.
 */

public class dp08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n+1];
        int[][] dp = new int[n+1][3];


        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1][1] = arr[1];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + arr[i];
            dp[i][2] = dp[i-1][1] + arr[i];
        }

        System.out.println((dp[n][1] > dp[n][2]) ? dp[n][1] : dp[n][2]);
    }
}

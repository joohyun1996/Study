package dp_second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 11066

/**
 * 틀렸다. 나는 dp만 써서 풀어보려 했는데, 그건 틀린 예제의 경우만 풀 수 있었다.
 * 이 문제를 풀려면 누적합도 같이 써야한다. 따라서 그 과정을 추가하니 문제 해결.
 * dp[i][j] 를 구하기 위해선 dp[i][k] + dp[k+1][j] 를 구하면 된다는것을 기억하자
 */
public class dp01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            int[] e = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] prefixSum = new int[v+1];
            for (int j = 1; j <= v; j++) {
                prefixSum[j] = prefixSum[j-1] + e[j-1];
            }

            int[][] dp = new int[v][v];

            for (int len = 2; len <= v; len++) {
                for (int j = 0; j <= v-len; j++) {
                    int k = j + len - 1;
                    dp[j][k] = Integer.MAX_VALUE;

                    for (int l = j; l < k; l++) {
                        int cost = dp[j][l] + dp[l+1][k] + prefixSum[k+1] - prefixSum[j];
                        dp[j][k] = Math.min(dp[j][k], cost);
                    }
                }
            }

            sb.append(dp[0][v-1]).append("\n");
        }
        System.out.println(sb);
    }
}

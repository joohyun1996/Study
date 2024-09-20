package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 1932

/**
 * 쉬운 형태의 dp 프로그래밍
 * 이전 배열 i-1 / i 와 현재 배열의 j값을 더해 그중 최댓값을 유지해 나가는 방식
 */
public class dp07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dp[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1]+arr[i][j], dp[i-1][j] + arr[i][j]);
                }
            }
        }

        Arrays.sort(dp[n-1]);
        System.out.println(dp[n-1][n-1]);
    }
}

package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 1463

/**
 * 아예 틀린 문제. 사실상 내가 푼 문제가 아니다.
 * bottom - up 방식으로 문제를 풀었는데, 나는 이전까지의 점화식처럼 2차원 배열로 풀고자 했다.
 * 하지만 n까지의 연산 횟수를 구하는 1차원 배열을 점화식으로 구성해서 문제를 풀었다.
 * 따라서 dp[1] = 0 (1은 1임), dp[2] = 1 ==> dp[2] = min(dp[1] + 1 , dp[2/2] + 1), dp[3] = min(dp[2]+1, dp[3/3]+1)
 * 이 점화식을 사용해 n을 따라가다보면 결국 n번째의 연산횟수가 나온다.
 */
public class dp09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] dp = new int[n + 1];

        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}

        /*int[][] dp = new int[100000][3]; 틀린 코드

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],n);
        }

        for (int i = 1; i < dp.length; i++) {
            if(dp[i-1][0] == 1 || dp[i-1][1] == 1 || dp[i-1][2] == 1){
                System.out.println(i-1);
                break;
            }

            for (int j = 0; j < 3; j++) {
                if(dp[i-1][j] % 3 == 0){
                    dp[i][0] = min(dp[i][0], dp[i-1][j]/3);
                }

                if(dp[i-1][j] % 2 == 0){
                    dp[i][1] = min(dp[i][1], dp[i-1][j]/2);
                }

                dp[i][2] = min(dp[i][2], dp[i-1][j]-1);
            }
        }*/

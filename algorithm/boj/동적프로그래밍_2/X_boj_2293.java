package dp_second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// boj 2293

/**
 * 이 문제는 knapsack 문제로 최대 무게를 초과하기 전까지 원소의 갯수를 반복해서 집어넣는 경우의수 찾기
 * 이전문제처럼 dp[i][j]의 형태로 구하려 했으나 그렇게 하는게 아니라 일차원 배열 dp를 구하는 문제
 * dp[j] = dp[j - arr[i]] (단 j = arr[i]) 의 점화식을 반복해 해당 인덱스 J 에 들어가는 경우의 수를 더한다
 * dp[2] = dp[1] + 1 // dp[0] + 2 => 이렇게 2가 된다
 * 이런식의 점화식을 반복하여 마지막 인덱스의 경우 최종 경우의 수는 dp[k]의 값이다 
 */
public class dp05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        int[] dp = new int[k+1];
        dp[0] = 1; // 0을 만드는 경우의수 = 1 (아무것도안쓰기)

        for (int i : arr) {
            for (int j = i; j <= k; j++) {
                dp[j] += dp[j - i];
//                System.out.println("dp[" + j + "]" + " = " + dp[j]);
            }
        }

        System.out.println(dp[k]);
    }
}

package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj_11055

/**
 * 그렇게 어렵지는 않았던 문제, 풀면서 각 입력이 이전 입력보다 크면 dp 배열에 이전 최댓값들의 합 + 현재값을 더해주면 된다.
 * 만약 지금 최댓값이 가장 크다면 해당 값을 그대로 저장하면 된다.
 */
public class dp12_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i],dp[j] + arr[i]);
                }
            }
        }

        int ans = 0;
        for (int i : dp) {
            ans = Math.max(ans, i);
        }

        System.out.println(ans);
    }
}

package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 2565

/**
 * 좌 -> 우 로 진행하는 가장 길은 부분 집합의 길이를 구한다.
 * 그 후 전체 선분의 갯수에서 가장 길은 부분 집합의 길이를 제거해 주면, 남은 선분의 길이가 나온다.
 * 따라서 n-ans를 출력하면 된다.
 */
public class dp14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[501];
        int[] dp = new int[501];

        String[] strs;
        for (int i = 0; i < n; i++) {
            strs = br.readLine().split(" ");
            arr[Integer.parseInt(strs[0])] = Integer.parseInt(strs[1]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= 500; i++) {
            if(arr[i] == 0){
                continue;
            }
            dp[i] = 1;
            max = Math.max(arr[i], max);
        }

        for (int i = 1; i <= max; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && arr[i] != 0 && arr[j] != 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i : dp) {
            if(i != 0){
                ans = Math.max(ans, i);
            }
        }

        System.out.println(n-ans);
    }
}

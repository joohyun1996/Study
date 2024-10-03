package cumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 2559

/**
 * 윈도우 슬라이드 문제
 * 이전 구간합을 구하는 문제에서 크기가 고정된 상태로 이동하는 문제
 * 0부터 N-1까지의 합을 미리 구하고, 구한 합들을 arr[i] - arr[i-m] 을 이용해 계속 이동시키면서 최댓값 혹은 최솟값을 구하면 된다
 */
public class cs2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int ans = 0;

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sum = new int[arr.length];
        sum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sum[i] += arr[i] + sum[i-1];
        }

        for (int i = 0; i < m; i++) {
            ans += arr[i];
        }

        for (int i = m; i < n; i++) {
            ans = Math.max(ans, sum[i] - sum[i-m]);
        }

        System.out.println(ans);
    }
}

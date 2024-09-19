package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 1149

/**
 * bottom - up 방식으로 dp를 풀어내는 문제
 * 맨 처음에는 그리디 방식으로 풀어보려 했으나, 오답이 나와 문제를 처음부터 다시 풀게 됨
 * 결국 0 -> 1,2 / 1 -> 0,2 / 2 -> 0,1 의 패턴이 반복되므로 매 입력마다 최솟값을 계속 유지해서 마지막 배열의 최솟값을 구하면 되도록 하였다.
 */
public class dp06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[][] arr = new int[n][3];
        int[][] ans = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < 3; i++) {
            ans[0][i] = arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            ans[i][0] = Math.min(ans[i-1][1] + arr[i][0], ans[i-1][2] + arr[i][0]);
            ans[i][1] = Math.min(ans[i-1][0] + arr[i][1], ans[i-1][2] + arr[i][1]);
            ans[i][2] = Math.min(ans[i-1][0] + arr[i][2], ans[i-1][1] + arr[i][2]);
        }

        Arrays.sort(ans[n-1]);
        System.out.println(ans[n-1][0]);
    }
}

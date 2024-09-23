package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 10844 (틀림)

/**
 * Top-down, Bottom-up 둘중 하나로 풀어야 한다.
 * 그런데 점화식을 그대로 쓰기 위해서는 Top-down으로 풀고, Bottom-up으로 바꾸는게 편하다.
 * 그런데 이 문제는 점화식 구하기를 틀림
 * 점화식 f[i][0] = f[i-1][1], f[i][9]=f[i-1][8], f[i][j] = f[i-1][j-1] + f[i-1][j+1];
 * 또한 overflow를 항상 생각하면서 풀어야 하는 문제
 */
public class dp10 {
    static int n;
    static Long[][] arr;
    static long Mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());
        arr = new Long[n+1][10];
        long ans = 0L;

        for (int i = 0; i < 10; i++) {
            arr[1][i] = 1L;
        }

        for (int i = 2; i <= n; i++) {
            arr[i][0] = arr[i-1][1] % Mod;
            for (int j = 1; j < 9; j++) {
                arr[i][j] = ((arr[i-1][j-1] % Mod) + (arr[i-1][j+1] % Mod)) % Mod;
            }
            arr[i][9] = arr[i-1][8] % Mod;
        }

        for (int i = 1; i < 10; i++) {
            ans = (ans + arr[n][i]) % Mod;
        }

        System.out.println(ans);
    }
}

package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 11053

/**
 * 틀린문제. LIS(최장 증가 부분 수열) 이라고 부분 수열의 길이를 구하는 유명한 문제이다.
 * https://propercoding.tistory.com/42 참고했다.
 * 그러니까 배열을 순회하면서, 특정 인덱스의 값이 그 이전의 인덱스의 값보다 크면, 그 갯수를 세어 dp배열에 넣어준다.
 * dp 배열은 처음엔 모두 1이고, i < J 일 경우, dp[i], dp[j]+1 중 큰 값을 dp[j]에 넣어준다.
 * 그 후 dp 배열의 최댓값을 출력
 */
public class dp12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[n];
        int[] dp  = new int[n];
        Arrays.fill(dp,1);

        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
    /*static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        dp = new int[n+1][n];
        String[] strs = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
            dp[0][i] = arr[i];
        }

        for (int i = 1; i < n; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(arr[i] > dp[i][j]){
                    tmp = Math.min(tmp, arr[i]);
                }else{
                    tmp = dp[i-1][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int tmp = 1;
            for (int j = 1; j < n+1; j++) {
                if(dp[j][i] > dp[j-1][i]){
                    tmp++;
                }
            }
            dp[n][i] = tmp;
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[n][i]);
        }

        System.out.println(ans);
    }*/

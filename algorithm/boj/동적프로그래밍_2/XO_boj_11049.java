package dp_second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// boj 11049

/**
 * 행렬곱 구하기 문제, i, j, k 범위 구하는게 힘들다
 * 다시한번 풀어봐야할 문제
 * len,i,j,k 를 써야한다는 사실은 알았지만, 범위를 어떻게 잡아야 할지 감을 못잡았음
 * len => 부분집합의 크기를 구한다 2개묶음, 3개묶음... n개묶음
 * i = 0 .... n - len 까지 돌아야 한다
 * j => 종료지점. 크기는 len + i - 1; (항상 i 보다 크고 n 보다 작음)
 * k -> i와 j 사이 반복하면서 dp[i][k] + dp[k+1][j] + 부분합 구하기 를 맡는다
 */

/**
 * 전체적인 문제 푸는 감은 찾았는데, 점화식 구할때 arr[i][0] * arr[j][1] * arr[k][1] 부분을 틀림
 * 해당 점화식만 잘 계산하면 될듯
 */
public class dp02 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] cells = new int[n][2];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) {
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            cells[i][0] = Integer.parseInt(st.nextToken());
            cells[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = len + i - 1;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + cells[i][0] * cells[k][1] * cells[j][1]);
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}

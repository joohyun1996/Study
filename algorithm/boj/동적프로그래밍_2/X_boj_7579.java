package dp_second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// boj 7579

/**
 *  dp를 사용해서 최소비용으로 필요한 메모리를 얻는 문제
 *  솔직히 너무 어렵다. 다시 풀어봐야 할듯
 *  Knapsack 문제 응용임.
 *  그래서 출력도 M보다 같거나 큰, 최소 인덱스를 출력하면 된다
 */
public class dp06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] weight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sumCost = Arrays.stream(cost).sum();

        int[] dp = new int[sumCost+1];

        for (int i = 0; i < n; i++) {
            for (int j = sumCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + weight[i]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= sumCost; i++) {
            if(dp[i] >= m){
                ans = Math.min(i, ans);
            }
        }
        System.out.println(ans);
    }
}

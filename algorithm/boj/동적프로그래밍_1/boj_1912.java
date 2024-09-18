package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// boj 1912

/**
 * 한번 틀린 문제
 * dp를 구함에 있어서, dp[i] = Max(dp[i-1] + arr[i], arr[i])를 구하는 문제.
 * 즉 지금까지의 연속합과, 새로운 숫자를 사용한 연속합 가운데 어떤 값이 더 큰지 계산하면 되는 문제
 * 이렇게 되면 O(n)수준으로 문제를 풀 수 있다
 */
public class dp05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Integer> ansList = new ArrayList<>();

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i-1]+arr[i] , arr[i]);
        }
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}

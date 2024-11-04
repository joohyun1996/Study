package cumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

// boj_10986

/**
 * 아예 접근을 못한 문제 누적합의 나머지값을 구할경우에 어떻게 할 것이냐? 를 물어보았다.
 * 지금까지의 누적합을 구하려면 arr[n+m] - arr[n] 을 해 주었을 때, 특정 구간의 합을 구할 수 있었다.
 * 나머지를 구하기 위해 양변에 mod(k)를 취해주면 arr[n+m] % mod(k) - arr[n] % mod(k) = k % mod(k) 가 됨을 알 수 있다
 * 즉 arr[n+m] % mod(k) = arr[n] % mod(k) 가 되기 때문에 누적합 배열을 k로 나눈 배열에서 같은 값을 지니는 인덱스가 2개 이상일 경우 해당 값을 nC2로 찾는 문제이다 
 */
public class cs4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        HashMap<Long,Integer> map = new HashMap<>();
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] sum = new long[n+1];

        sum[0] = 0;

        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + arr[i];
        }

        for (int i = 0; i <= n; i++) {
            long mod = sum[i] % m;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        long ans = 0;
        for (Integer value : map.values()) {
            if(value > 1){
                ans += ((long)value * (value-1)) / 2;
            }
        }

        System.out.println(ans);
    }
}

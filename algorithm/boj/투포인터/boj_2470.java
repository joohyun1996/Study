package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 2470

/**
 * 투포인터로 풀어보는 문제
 * if-elif-else 부분을 잘 찾지 못해서 틀린 문제
 * 0을 기준으로 0이하 0이상 0인경우 나누어서 투포인터로 풀어보면 쉽다.
 * 이분탐색으로도 풀 수 있다니 고려
 */
public class tp2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        long[] inputs = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Arrays.sort(inputs);


        long[] ans = twoPointer(inputs);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static long[] twoPointer(long[] inputs){
        int start = 0;
        int end = inputs.length-1;
        long sum = Long.MAX_VALUE;
        long[] ans = new long[2];

        while(start < end){
            long tmp = inputs[start] + inputs[end];
            if(Math.abs(sum) > Math.abs(tmp)){
                sum = Math.abs(tmp);
                ans[0] = inputs[start];
                ans[1] = inputs[end];
            }
            if (tmp == 0){
                return new long[]{inputs[start], inputs[end]};
            }else if(tmp < 0){
                start++;
            }else{
                end--;
            }
        }
        return ans;
    }
}

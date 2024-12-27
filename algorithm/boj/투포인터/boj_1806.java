package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 1806

/**
 * 투포인터와 누적합을 사용해서 푸는 문제
 * 기존의 투포인터처럼 start = 0, end = len-1로 풀려하니까 답이 없음
 * 그래서 start = 0, end = 1로 가정하고 하나씩 값을 증가시키면서 구간을 찾아서 해결
 */
public class tp3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] baseInputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = baseInputs[0];
        int s = baseInputs[1];

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] summation = new int[n+1];
        summation[0] = 0;

        for (int i = 0; i < n; i++) {
            summation[i+1] = inputs[i] + summation[i];
        }

        int ans = twoPointer(summation, s);
        System.out.println(ans);
    }
    public static int twoPointer(int[] arr, int sum){
        int start = 0;
        int end = 1;
        int ans = Integer.MAX_VALUE;
        while(start <= end && end <= arr.length-1){
            int tmp = arr[end] - arr[start];
            if(sum == tmp){
                if(ans > (end-start)){
                    ans = end-start;
                }
                end++;
            }else if(sum < tmp){
                if(ans > (end-start)){
                    ans = end - start;
                }
                start++;
            }else{
                if(end < arr.length-1) end++;
                else start++;
            }
        }

        if(ans != Integer.MAX_VALUE) return ans;
        else return 0;
    }
}

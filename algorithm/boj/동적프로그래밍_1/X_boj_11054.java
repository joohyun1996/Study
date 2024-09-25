package dp_first;

// boj 11054

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * boj 11054
 * 가장 긴 바이토닉 수열 찾기, 한번 틀리고 찾아본 문제
 * 결론적으로 바이토닉 수열을 찾기 위해서, 좌 -> 우 로 증가하는 수열의 크기와 우 -> 좌로 증가하는 수열의 최대 크기를 찾는다
 * 그 후 두 수열의 합 -1 을 해준 수열(자기 자신은 두번 더해짐)중 최댓값을 구하는 문제이다.
 * 나는 좌->우로 증가하는 순열중 최대값을 가지는 위치의 인덱스를 찾고, 해당 인덱스부터 작아지는 순열을 계산해서 그 수를 더해주려 했는데, 그 방법은 오답이 나왔다.
 */
public class dp13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine().trim());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp_asc = new int[n];
        int[] dp_desc = new int[n];
        int[] ans = new int[n];

        Arrays.fill(dp_asc,1);
        Arrays.fill(dp_desc,1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    dp_asc[i] = Math.max(dp_asc[i], dp_asc[j]+1);
                }
            }
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = n-1; j > i; j--) {
                if(arr[i] > arr[j]){
                    dp_desc[i] = Math.max(dp_desc[i], dp_desc[j]+1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans[i] = dp_asc[i] + dp_desc[i] -1;
            max = Math.max(ans[i], max);
        }

        System.out.println(max);
    }
}


/*for (int i = 1; i < n; i++) { 틀린코드
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int dpMax = 0;
        int dpIdx = -1;

        if(dpIdx == n-1){

        }
        for (int i = 0; i < n; i++) {
            if(dp[i] > dpMax){
                dpMax = dp[i];
                dpIdx = i;
            }
        }

        int ans = 1;
        int min = dp[0];
        int max = dp[dpIdx];

        if(dpIdx == 0){
            for (int i = dpIdx; i < n-1; i++) {
                if(max > dp[i+1]){
                    max = dp[i+1];
                    ans++;
                }
            }
        }else if(dpIdx == n-1){
            for (int i = 0; i < n-1; i++) {
                if(dp[i+1] > min){
                    min = dp[i+1];
                    ans++;
                }
            }
        }else{
            for (int i = 0; i <= dpIdx; i++) {
                if(dp[i+1] > min){
                    min = dp[i+1];
                    ans++;
                }
            }

            for (int i = dpIdx; i < n-1; i++) {
                if(max > dp[i+1]){
                    max = dp[i+1];
                    ans++;
                }
            }
        }*/

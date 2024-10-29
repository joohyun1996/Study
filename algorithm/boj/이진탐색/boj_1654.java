package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 1654

/**
 * 이분탐색으로 상한 접근 찾기
 * 이분탐색으로 특정 숫자를 찾을때, 하한 접근으로 찾거나 상한 접근으로 찾아야 한다.
 * 그때 상한 탐색을 잘 할 수 있는지 물어보는 문제
 * 하한탐색 : end = middle - 1
 * 상한탐색 : start = middle + 1
 */
public class bs3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine().trim());
        }

        Arrays.sort(arr);

        long start = 0;
        long mid = 0;
        long end = arr[n-1]+1; // 최소 0, 최대 1일경우 대비해 +1
        long ans = 0;

        while(start < end){
            mid = (start + end) / 2;
            long cnt = 0;

            for (int i = 0; i < n; i++) {
                cnt += arr[i] / mid;
            }
            if(cnt >= k){
                ans = mid;
                start = mid+1;
            }else{
                end = mid;
            }
        }

        System.out.println(ans);
    }
}

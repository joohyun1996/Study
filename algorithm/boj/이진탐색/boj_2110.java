package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 2110

/**
 * 이분탐색을 실시할때 upper bound, lower bound를 얼마나 잘 아는지 설명하라는 문제
 * 그런데 늘 했던것은 start < end의 조건이었는데, 이번에는 start <= end로 해야 풀렸다. 왜냐하면 start == end 인 경우에도 한번 더 검사를 해줘야 했기 때문
 * 또한 middle이 오답인 경우 범위 축소를 위해 end = middle -1 적용
 * 초기값도 범위상 최대,최소값이기 때문에 start = 1(1,2,3....,n), end = arr[n-1]-arr[0];
 */
public class bs5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int c = Integer.parseInt(strs[1]);

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine().trim());
        }
        Arrays.sort(arr);

        long start = 1;
        long end = arr[n-1]-arr[0];
        long middle = 0;
        long ans = 0;

        while(start <= end){
            middle = (start + end) / 2;
            long chk = 1;
            long tmp = arr[0];

            for (int i = 1; i < n; i++) {
                if((arr[i] - tmp) >= middle){
                    chk++;
                    tmp = arr[i];
                }
            }

            if(c > chk){
                end = middle-1;
            }else{
                start = middle+1;
                ans = middle;
            }
        }
        System.out.println(ans);
    }
}

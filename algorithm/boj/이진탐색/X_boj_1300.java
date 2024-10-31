package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj_1300

/**
 * 너무 어려웠던 문제
 * 이분탐색을 정확히 알고 써야한다.
 * while(start < end) // while(start <= end)
 *
 * if-else 설정하는것. Middle + 1 / Middle -1 하는것 모두 다 고려해야 한다.
 */
public class bs6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int k = Integer.parseInt(br.readLine().trim());

        long start = 1;
        long end = k;
        long middle = 0;
        long answer = 0;

        while(start < end){
            middle = (start + end) / 2;
            long tmp = 0;

            for (int i = 1; i <= n ; i++) {
                tmp += Math.min(middle / i, n);
            }

            if(tmp >= k){
                end = middle;
            }else{
                start = middle + 1;
            }
        }

        System.out.println(start);
    }
}

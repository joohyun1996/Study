package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj_2805

/**
 * 특정 선분이 있을떄, 모든 선분에서 필요한 만큼 길이를 얻기 위한 최소의 수치를 이분탐색으로 구하는 문제.
 * 즉, 7만큼 필요한데, 6또는 8만큼 잘라야 한다면 8을 골라야 한다.
 * 따라서 하한 접근으로 해당 값보다 큰 값을 찾으면 된다.(같으면 좋고 >=)
 */
public class bs4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);

        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();

        long start = 0;
        long middle = 0;
        long end = arr[n-1]+1;
        long ans = 0;

        while(start < end){
            middle = (start + end) / 2;
            long tmp = 0;
            for (long i : arr) {
                if(i >= middle){
                    tmp += i - middle;
                }
            }

            if(tmp >= k){
                start = middle + 1;
                ans = middle;
            }else{
                end = middle;
            }
        }

        System.out.println(ans);
    }
}

package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 1904
// 00, 1만 사용해서 N개의 카드가 주어졌을 때 몇개의 가능한 수가 있냐? 를 찾는 문제
// N = 7 까지 구했을 때, 피보나치 수열이 발견되었는데, 매 경우 15746으로 나누어 주지 않으면 값이 너무 커져서 오답이 나온다
// 따라서 해당 내용 추가해 줘야 한다.
public class dp03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n+1];

        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < n+1; i++) {
            arr[i] = (arr[i-1] + arr[i-2])%15746;
        }

        System.out.println(arr[n]);


    }
}

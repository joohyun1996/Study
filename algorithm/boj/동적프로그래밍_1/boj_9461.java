package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 9461
// 파도반 수열 이라는 문제였는데, 결국 피보나치 수열의 변형에 불과함
// 배열로 풀면 특이할 것 없는 평이한 문제
public class dp04 {
    static long [] arr = new long [101];
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        arr[0] = -1;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i < 101; i++) {
            arr[i] = arr[i-2] + arr[i-3];
        }
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine().trim());
            System.out.println(arr[m]);
        }

    }
}

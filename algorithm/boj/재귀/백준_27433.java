package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 27433
// 재귀를 배열을 이용하여 구현. N이 20까지이기 때문에 double을 이용하였다.
public class Recursion01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        double[] arr = new double[21];
        arr[0] = 1;

        for (int i = 1; i < 21; i++) {
            arr[i] = arr[i-1] * i;
        }

        System.out.println((long)arr[n]);
    }
}

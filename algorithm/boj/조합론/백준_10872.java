package combinatorics;

import java.io.*;

// boj 10872
// 피보나치 수열을 배열로 구현함. 재귀보다는 배열이 빠르기 때문(꼬리재귀 제외)
public class Comb03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[13];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 1; i <= n; i++) {
            arr[i] = i * arr[i-1];
        }

        bw.write(arr[n] + "");
        bw.flush();
        bw.close();
    }
}

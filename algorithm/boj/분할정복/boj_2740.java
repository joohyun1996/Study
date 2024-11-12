package divideConquer;

import java.io.*;
import java.util.Arrays;


// boj 2740

/**
 * 행렬곱을 아는지 물어보는 문제
 * n*k = n*j * j*k 임을 알면 문제 없다.
 * 스트라센 행렬을 이용해서 처리하는 방법도 있다
 */
public class dc5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        int[][] arrA = new int[n][m];
        for (int i = 0; i < n; i++) {
            arrA[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        strs = br.readLine().split(" ");

        int k = Integer.parseInt(strs[1]);
        int[][] arrB = new int[m][k];

        for (int i = 0; i < m; i++) {
            arrB[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        long[][] arrAns = new long[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < m; l++) {
                    arrAns[i][j] += (long)arrA[i][l] * arrB[l][j];
                }
            }
        }

        for (long[] i : arrAns) {
            for (long l : i) {
                bw.write(l + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}

package divideConquer;

import java.io.*;
import java.util.Arrays;


// boj 10830

/**
 * 행렬의 거듭제곱꼴을 구할떄 다 곱할수도 없고, A^n = PD^nP^-1 이 식을 적용할 수 도 없다
 * 따라서 재귀적으로 A^5 = A^2 * A*3 (= A^2 * A^1)을 이용해서 풀어야 한다
 * 이때 재귀적으로 들어가면서 분할정복을 사용
 */
public class dc6 {
    static long[][] board;
    static long[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        long b = Long.parseLong(strs[1]);

        board = new long[n][n];
        ans = new long[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }

        ans = divideMatrix(n, b);

        for (long[] an : ans) {
            for (long l : an) {
                bw.write(l % 1000 + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static long[][] divideMatrix(int n, long b){
        if(b==1){
            long[][] result = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    result[i][j] = board[i][j] % 1000;
                }
            }
            return result;
        }

        long[][] half = divideMatrix(n, b/2);
        long[][] halfSquare = multiply(half, half, n);

        if(b % 2 == 0){
            return halfSquare;
        }else{
            return multiply(halfSquare, board, n);
        }
    }

    public static long[][] multiply(long[][] a, long[][] b, int n){
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long tmp = 0;
                for (int k = 0; k < n; k++) {
                    tmp += a[i][k] * b[k][j];
                }
                result[i][j] = tmp % 1000;
            }
        }
        return result;
    }
}

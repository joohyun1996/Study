package combinatorics;

import java.io.*;

// boj 1010
// 특별할 것 없는 조합문제. 하지만 type을 꼭 확인하여 int 의 범위가 넘어가는 경우 오버플로우 문제 생각해야함
public class Comb05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < size; i++) {
            String[] strs = br.readLine().split(" ");
            int n = Integer.parseInt(strs[1]);
            int k = Integer.parseInt(strs[0]);

            long up = 1;
            long down = 1;

            for (int j = n; j > (n - k); j--) {
                up *= j;
            }

            for (int j = k; j > 0; j--) {
                down *= j;
            }

            bw.write(up / down + "\n");
        }
        bw.flush();
        bw.close();
    }
}

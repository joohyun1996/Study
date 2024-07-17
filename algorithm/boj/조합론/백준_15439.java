package combinatorics;

import java.io.*;

// boj 15439
// 조합이 아니라 단순 곱셈 문제
public class Comb01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());

        bw.write(n*(n-1) + "");
        bw.flush();
        bw.close();
    }
}

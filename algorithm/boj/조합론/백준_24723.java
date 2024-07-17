package combinatorics;

import java.io.*;

// boj 24723
// 각 층에서 다른 층으로 가는 방법은 2개. 해당 과정이 n개의 층만큼 반복되므로 2^n이 정답
public class Comb02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        int answer = 1;

        for (int i = 0; i < n; i++) {
            answer *= 2;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}

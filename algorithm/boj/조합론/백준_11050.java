package combinatorics;

import java.io.*;

// boj 11050
public class Comb04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);

        int up = 1;
        int down = 1;
        for (int i = n; i > (n-k); i--) {
            up *= i;
        }
        for (int i = k; i > 0; i--) {
            down *= i;
        }
        bw.write(up/down + "");
        bw.flush();
        bw.close();
    }
}

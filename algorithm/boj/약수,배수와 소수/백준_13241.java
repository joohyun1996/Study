package number2;

import java.io.*;
import java.math.BigInteger;

// boj 13241
public class Number02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().trim().split(" ");

        BigInteger n = BigInteger.valueOf(Long.parseLong(strs[0]));
        BigInteger m = BigInteger.valueOf(Long.parseLong(strs[1]));

        BigInteger gcd = n.gcd(m);

        bw.write(n.longValue() * m.longValue() / gcd.longValue() + "\n");
        bw.flush();
        bw.close();
    }
}

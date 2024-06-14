package number2;

import java.io.*;
import java.math.BigInteger;

// boj 1934
// BigInteger로 gcd 계산, 후 lcm = n * m / gcd
public class Number01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < size; i++) {
            String[] strs = br.readLine().trim().split(" ");
            BigInteger n = BigInteger.valueOf(Long.valueOf(strs[0]));
            BigInteger m = BigInteger.valueOf(Long.valueOf(strs[1]));

            BigInteger gcm = n.gcd(m);

            bw.write((n.intValue() * m.intValue()) / gcm.intValue() + "\n");
        }
        bw.flush();
        bw.close();
    }
}

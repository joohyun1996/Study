package number2;

import java.io.*;
import java.math.BigInteger;

// boj 1735
// 분모를 최소공배수로 바꾸고, 분자 = 분자 * (최소공배수 / 분모) 형태로 바꾼 뒤
// 분자, 분모 를 최대공약수로 나누어준다
public class Number03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().trim().split(" ");
        BigInteger xNumerator = BigInteger.valueOf(Long.parseLong(strs[0]));
        BigInteger xDenominator = BigInteger.valueOf(Long.parseLong(strs[1]));

        strs = br.readLine().trim().split(" ");
        BigInteger yNumerator = BigInteger.valueOf(Long.parseLong(strs[0]));
        BigInteger yDenominator = BigInteger.valueOf(Long.parseLong(strs[1]));

        int tmpDenominator = lcm(xDenominator,yDenominator);
        int tmpNumerator = xNumerator.intValue() * (tmpDenominator / xDenominator.intValue()) + yNumerator.intValue() * (tmpDenominator / yDenominator.intValue());

        int numerator = tmpNumerator / BigInteger.valueOf(tmpNumerator).gcd(BigInteger.valueOf(tmpDenominator)).intValue();
        int denomiator = tmpDenominator / BigInteger.valueOf(tmpNumerator).gcd(BigInteger.valueOf(tmpDenominator)).intValue();

        System.out.println(numerator + " " + denomiator);
    }

    public static int lcm(BigInteger x, BigInteger y){
        return (x.intValue() * y.intValue()) / x.gcd(y).intValue();
    }
}

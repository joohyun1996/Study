package divideConquer;

// boj 11401

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// boj 11401
/**
 * 이항계수, 페르마의 소정리 공식을 알아야만 풀 수 있는 문제
 * 기존의 이항 계수 문제는 n-1Cr + n-1Cr-1 = nCr이 되었지만 단위가 커지면 이게 안됨
 * 따라서 a^p =(닮음) a mod p => a^p mod p = a mod p 를 이용해야 한다.
 * 또한 a^(p-1) = 1 * mod p, a^(p-2) = a^(-1) mod p 임을 기억하면 된다
 * (n! / (n-r)! * r!) mod p ==> n! (mod p) * ((r! * (n-r)!)^(-1) mod p )) mod p
 * = n! mod p * (r! * (n-r)!) ^(p-2) mod p 가 된다. 따라서 이 수식에 맞춰서 문제를 풀면 된다
 * 그런데 이게 페르마의 소정리를 모르면 못푸는 문제인데 이걸....
 */
public class dc4 {
    static long p = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        long numerator = factorial(n);
        long denominator = factorial(m) * factorial(n-m) % p;

        System.out.println(numerator * pow(denominator, p-2) % p);
    }
    public static long factorial(int n){
        long tmp = 1;
        for (int i = n; i > 1; i--) {
            tmp = (tmp * i) % p;
        }
        return tmp;
    }
    public static long pow (long base, long exp){
        if(exp == 1){
            return base % p;
        }

        long tmp = pow(base, exp/2);

        if (exp % 2 == 1){
            return (tmp * tmp % p) * base % p;
        }
        return tmp * tmp % p;
    }
}

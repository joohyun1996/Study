package number2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// boj 4948
// n < primeNumber <= 2n 사이의 소수 갯수 구하는 문제, 에라토스테네스의 체 사용
public class Number07 {
    static List<Integer> primeList = new ArrayList<>();
    static boolean[] chk = new boolean[123456*2+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        isPrime();
        while(true){
            int n = Integer.parseInt(br.readLine().trim());
            if(n == 0) break;
            System.out.println(primeList.stream().filter(r -> r > n && r <= 2*n).count());
        }
    }
    static void isPrime(){
        for (int i = 2; i <= 123456*2; i++) {
            if(!chk[i]){
                for (int j = i+i; j <= 123456*2 ; j += i) {
                    chk[j] = true;
                }
                primeList.add(i);
            }
        }
    }
}

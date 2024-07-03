package number2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 17103

/**
 * 짝수는 두개의 소수의 합으로 구할 수 있다는 문제
 * 생각한 방식은 유사한데, 나는 이전 풀이처럼 소수를 리스트에 저장해서 이중 for문을 사용해 계산하려 하였고, 생각해보니 그냥 bool[]만 사용해서 풀어도 문제가 없음
 * 이전 방식은 주석처리
 */

public class Number08 {
    static boolean[] chk = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        isPrime();
        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine().trim());
            int ans = 0;
            for (int j = 2; j <= tmp/2; j++) {
                if(!chk[j]){
                    if(!chk[tmp-j]){
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
    static void isPrime(){
        for (int i = 2; i <= 1000000; i++) {
            if(!chk[i]){
                for (int j = i+i; j <= 1000000; j+=i) {
                    chk[j] = true;
                }
            }
        }
    }
}


/*

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[] chk = new boolean[1000001];
    static List<Integer> primeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        isPrime();
        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine().trim());
            int ans = 0;
            for (int j = 0; primeList.get(j) <= tmp; j++) {
                for (int k = j; primeList.get(k) <= tmp; k++) {
                    if(primeList.get(j) + primeList.get(k) == tmp) ans++;
                }
            }
            System.out.println(ans);
        }
    }
    static void isPrime(){
        for (int i = 2; i <= 1000000; i++) {
            if(!chk[i]){
                for (int j = i+i; j <= 1000000; j+=i) {
                    chk[j] = true;
                }
                primeList.add(i);
            }
        }
    }
}

 */

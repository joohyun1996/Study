package number2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 4134

/**
 * 에라토스 테네스의 체를 통해 주어진 수 의 다음 소수를 구하는 문제(같거나 큰)
 * 1) 에라토스테네스의 체를 4억까지 미리 계산하고 (최대수) 거기서 뽑아쓰려 했는데 메모리 에러
 * 2) 그러면 매번 n++ 해서 다음 소수까지 찾는 방식으로 하려 했더니 numberformat 에러
 * 3) 따라서 int에서 long으로 바꿔서 해결함
 */

public class Number5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long size = Long.parseLong(br.readLine().trim());

        for (long i = 0; i < size; i++) {
            long number = Long.parseLong(br.readLine().trim());

            while(!findPrime(number)){
                number++;
            }
            System.out.println(number);
        }
    }
    public static boolean findPrime(long n){
        if(n < 2){
            return false;
        }else{
            for (long i = 2; i <= Math.sqrt(n); i++){
                if (n % i == 0) return false;
            }
        }
        return true;
    }
}

package number2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 4134

/**
 * 에라토스 테네스의 체를 통해 주어진 수 의 다음 소수를 구하는 문제(같거나 큰)
 * 1) 에라토스테네스의 체를 4억까지 미리 계산하고 (최대수) 거기서 뽑아쓰려 했는데 메모리 에러
 * 2) 그러면 매번 n++ 해서 다음 소수까지 찾는 방식으로 하려 했더니 numberformat 에러
 * 3) 따라서 int에서 long으로 바꿔서 해결함
 */

public class Number5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long size = Long.parseLong(br.readLine().trim());

        for (long i = 0; i < size; i++) {
            long number = Long.parseLong(br.readLine().trim());

            while(!findPrime(number)){
                number++;
            }
            System.out.println(number);
        }
    }
    public static boolean findPrime(long n){
        if(n < 2){
            return false;
        }else{
            for (long i = 2; i <= Math.sqrt(n); i++){
                if (n % i == 0) return false;
            }
        }
        return true;
    }
}


// 4억까지 미리 계산 후 찾는 알고리즘
/*import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> primeList = new ArrayList<>();
    static boolean[] chkArr = new boolean[400000002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());

        findPrime();

        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(br.readLine().trim());
            for (int j = 0; j < primeList.size(); j++) {
                if(number > primeList.get(j)) continue;
                else{
                    System.out.println(primeList.get(j));
                    break;
                }
            }
        }
    }
    public static void findPrime(){
        for (int i = 2; i <= 400000001; i++) {
            if(!chkArr[i]){
                for (int j = i+i; j <= 400000001; j += i) {
                    chkArr[j] = true;
                }
                primeList.add(i);
            }
        }
    }
}*/


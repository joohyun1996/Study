package number2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// boj 1929
// 에라토스 테네스의 체를 활용해서 푸는 문제, 다만 n~m까지 범위에서만 구한다는것을 생각
// 따라서 해당 범위만 리스트에 넣고 출력
public class Number06 {
    static List<Integer> primeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().trim().split(" ");
        int startPrime = Integer.parseInt(strs[0]);
        int endPrime = Integer.parseInt(strs[1]);

        isPrime(startPrime, endPrime);

        for (Integer i : primeList) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void isPrime(int start, int end){
        boolean[] chk = new boolean[end+1];
        for (int i = 2; i * i <= end; i++) {
            if(!chk[i]){
                for (int j = i+i; j <= end; j+=i) {
                    chk[j] = true;
                }
            }
        }
        for (int i = 2; i < end+1; i++) {
            if(!chk[i] && (i >= start && i <= end)){
                primeList.add(i);
            }
        }
    }
}

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 1463

/**
 * 전에 한번 풀어봤었던 문제.
 * 6의 숫자가 3개인지만 체크하는게 아니라 6이 연속으로 3개가 붙은 경우를 봐야함
 * 따라서 contains("666")을 확인해야 한다.
 */
public class Bruteforce05 {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if(Integer.toString(i).contains("666")) answer++;
            if(answer == index){
                System.out.println(i);
                return;
            }
        }
    }
}

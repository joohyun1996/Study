package number2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 3474

/**
 * 10의 갯수를 구하는 문제. 즉 정수를 나누어서 2와 5의 조합으로 10을 최대 몇개 만들 수 있느냐? 를 물어보는 문제다.
 * 따라서 2로 나눈 최대 갯수와 5로 나눈 최대 갯수를 구하고 그중 최솟값을 찾아서 반환하면 된다.
 */
public class Number10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine().trim());

            int twoMultiple = findMultiple(tmp, 2);
            int fiveMultiple = findMultiple(tmp, 5);

            System.out.println(Math.min(twoMultiple, fiveMultiple));
        }

    }

    public static int findMultiple(int n, int tmp){
        int count = 0;

        // N 까지 검사해줘야 하는거 잊지말기
        for (int i = tmp; i <= n; i *= tmp) {
            count += n / i;
        }

        return count;
    }
}

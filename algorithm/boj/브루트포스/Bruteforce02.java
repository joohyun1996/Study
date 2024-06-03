package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// boj 2231
public class Bruteforce02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine().trim());
        int answer = 0;

        for (int i = 1; i < number; i++) {
            int tmp = i;
            List<Integer> list = new ArrayList<>();
            list.add(tmp);
            while (tmp != 0) {
                list.add(tmp % 10);
                tmp /= 10;
            }
            if (list.stream().reduce((a, b) -> a + b).get() == number) {
                answer = list.get(0);
                break;
            }
        }
        System.out.println(answer);
    }
}

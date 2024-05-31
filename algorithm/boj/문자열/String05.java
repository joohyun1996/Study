package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 10809
public class String05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] answer = new int[26];
        Arrays.fill(answer, -1);
        String str = br.readLine().trim();

        for (int i = 0; i < str.length(); i++) {
            answer[str.charAt(i)-97] = str.indexOf(str.charAt(i));
        }

        for (int i : answer) {
            System.out.printf("%d ", i);
        }

    }
}

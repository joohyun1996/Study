package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj_10808

/**
 * A => 65
 * a => 97
 */
public class String11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];
        Arrays.fill(arr,0);

        String str = br.readLine().trim();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            arr[(int)c-97]++;
        }

        for (int i : arr) {
            System.out.printf(i + " ");
        }
    }
}

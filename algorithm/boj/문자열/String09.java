package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 5622
public class String09 {
    public static void main(String[] args) throws IOException {
        int[] arr = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10,11,11,11,12,12,12,12};
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        for (char c : str.toCharArray()) {
            answer += arr[(int) c - 65];
        }
        System.out.println(answer);
    }
}

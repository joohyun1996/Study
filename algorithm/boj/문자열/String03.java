package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 9086
public class String03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = (int) br.readLine().trim().charAt(0);

        System.out.println(answer);
    }
}

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//boj 27866
public class String01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        int findIndex = Integer.parseInt(br.readLine().trim())-1;

        System.out.println(str.charAt(findIndex));
    }
}

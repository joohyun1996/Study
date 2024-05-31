package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//boj 2743
public class String02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().trim();
        System.out.println(str.length());
    }
}

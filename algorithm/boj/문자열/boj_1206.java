package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 1206

/**
 * startsWith, endsWith 를 substring으로 풀어버림
 * 존재하는 함수는 잘 쓰자
 */
public class String14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine().trim());
        String[] template = br.readLine().trim().split("\\*");

        String start = template[0];
        String end = template[1];

        for (int i = 0; i < size; i++) {
            String str = br.readLine();

            if(start.length() + end.length() <= str.length() && (str.startsWith(start) && str.endsWith(end))) {
                System.out.println("DA");
            }else{
                System.out.println("NE");
            }
        }
    }
}

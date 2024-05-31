package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 1152
// 띄어쓰기만 들어오는 경우 주의!
public class String07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().trim().split(" ");
        if(strs.length == 1 && strs[0] == ""){
            System.out.println(0);
            return;
        }
        System.out.println(strs.length);
    }
}

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 2908
public class String08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().trim().split(" ");
        String n = strs[0];
        String m = strs[1];

        StringBuilder sbN = new StringBuilder();
        StringBuilder sbM = new StringBuilder();


        for (int i = 1; i <= 3; i++) {
            sbN.append(n.charAt(3-i));
            sbM.append(m.charAt(3-i));
        }

        System.out.println((Integer.parseInt(sbN.toString()) > Integer.parseInt(sbM.toString())) ? Integer.parseInt(sbN.toString()) : Integer.parseInt(sbM.toString()));
    }
}

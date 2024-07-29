package recursion;

import java.io.*;

// boj 25501
// 이미 주어진 펠린드롬을 풀어보기
public class Recursion03 {
    static int cnt = 0;
    public static int recursion(String s, int l, int r){
        ++cnt;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            bw.write(isPalindrome(tmp) + " " + cnt + "\n");
            cnt = 0;
        }

        bw.flush();
        bw.close();
    }
}

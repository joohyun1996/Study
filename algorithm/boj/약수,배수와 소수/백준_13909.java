package number2;

// boj 13909

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 13909
// 결국 소수의 배수번 창문을 열고 닫으면 sqrt(n)의 갯수와 같아지는 문제
// 근데 왜 그런지는 정확히 알지 못했고, 추측한 결과가 맞았다
// 아래 코드는 메모리 부족으로 실패햇지만, 그 덕분에 sqrt(n) 추측하게 됨
public class Number09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        System.out.println((int) Math.sqrt(n));
    }
}
/*

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int ans = 0;

        boolean[] chk = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j+=i) {
                chk[j] = !chk[j];
            }
        }
        for (boolean b : chk) {
            if(b) ++ ans;
        }
        System.out.println(ans);
    }
}

 */

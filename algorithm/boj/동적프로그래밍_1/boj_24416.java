package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 24416
// 피보나치와 다이나믹프로그래밍 비교
public class dp01 {
    static int rAns = 0;
    static int dAns = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        recursive(n);
        dp(n);
        System.out.println(rAns + " " + dAns);
    }

    public static int recursive(int n){
        if (n == 1 || n == 2) {
            rAns++;
            return 1;
        }
        else return (recursive(n-1) + recursive(n-2));
    }

    public static int dp(int n){
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            dAns++;
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n-1];
    }
}

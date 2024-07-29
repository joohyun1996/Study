package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 10870
// 꼬리재귀함수로 문제해결
// 꼬리재귀함수 자연스럽게 사용해야함
public class Recursion02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(fibo(n, 0, 1));
    }

    public static int fibo(int n, int a, int b){
        if(n == 0){
            return a;
        }
        return fibo(n-1, b, a+b);
    }
}

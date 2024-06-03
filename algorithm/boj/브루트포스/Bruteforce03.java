package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 19532
// 특별할것 없는 연립 일차 방정식의 해 구하기 
public class Bruteforce03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int d = arr[3];
        int e = arr[4];
        int f = arr[5];

        int x = (e*c - b*f) / (a*e - b*d);
        int y = (-c*d + a*f) / (a*e - b*d);

        System.out.println(x + " " + y);
    }
}

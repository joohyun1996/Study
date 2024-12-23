package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 3273

/**
 * 투 포인터로 두 수의 합을 구하는 문제
 * 나는 두 포인터가 0,1번 인덱스에서 시작한다 가정하고 문제를 풀었다. 그런데 start = 0 // end = arr.length-1로 가정하고 풀어야 한다.
 * 그러면 문제가 풀림
 */
public class tp1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(br.readLine().trim());

        Arrays.sort(inputs);

        int ans = twoPointer(inputs, x);

        System.out.println(ans);
    }

    public static int twoPointer(int[] arr, int x){
        int start = 0;
        int end = arr.length-1;
        int ans = 0;

        while(start < end) {
            if(arr[start] + arr[end] == x){
                ans++;
                start++;
                end--;
            } else if (arr[start] + arr[end] < x) {
                start++;
            } else{
                end--;
            }
        }

        return ans;
    }
}

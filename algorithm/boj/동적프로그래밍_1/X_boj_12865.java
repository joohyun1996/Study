package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 12865

/**
 * 틀린문제. 0-1 Knap sack이란 무엇인가
 * dp 문제답게 이전까지 최댓값을 저장한 값 + 현재 가치의 값이 이전 무게의 최댓값과 비교하여 어떤게 더 컸는지 확인하는 문제
 * 어려워서 2일 걸렸고 해당 블로그를 참고 (https://st-lab.tistory.com/141)
 * 1차원 배열로 바꾸어 풀 수 있다.(굳이 메모리 낭비 X)
 */
public class dp16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int size = Integer.parseInt(strs[1]);

        int[] arr = new int[n+1];
        int[] price = new int[n+1];

        for (int i = 1; i <= n; i++) {
            strs = br.readLine().split(" ");
            arr[i] = Integer.parseInt(strs[0]);
            price[i] = Integer.parseInt(strs[1]);
        }

        int[][] map = new int [n+1][size+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= size; j++) {
                if(arr[i] > j){
                    map[i][j] = map[i-1][j];
                }else{
                    map[i][j] = Math.max(map[i-1][j], map[i-1][j-arr[i]]+price[i]);
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i <= size; i++) {
            ans = Math.max(map[n][i], ans);
        }

        System.out.println(ans);
    }
}
    /*
    일차원 배열로 구성시 다음과 같이 하면 된다.

    for(int = 1; i <= n; i++){
        for(int j = size; j - arr[i] >= 0; j--){
            dp[j] = Math.max(dp[j], dp[j-arr[i]] + price[i]);
        }
    }
    */

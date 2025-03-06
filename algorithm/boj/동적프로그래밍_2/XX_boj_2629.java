package dp_second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// boj 2629

/**
 * 2차원 boolean dp배열을 이용해서
 * 모든 추와 무게를 방문한다. 또한 방문시
 * 1) 방문하지 않는다 dp[i][j] = dp[i-1][j]
 * 2) 방문했으면 기존 값에 더한다 dp[i][j + weight[i-1]] = true;
 * 3) 기존 값에서 빼본다 dp[i][j - weight[i-1]] = true; or dp[i][Math.abs(j - weight[i-1])] = true;
 * 를 반복하고, 최종 구해야 하는 무게는 dp[size][i]에서 t/f를 구한다
 * 다시 풀었늗네 결국 또 틀렸다. 이 문제에서 점화식을 구할 때 알아야하는게, 
 * 1) 최대무게를 넘지 않았다면 -> 같은 저울에 두개 놓기, 다른 저울에 각자 놓기 가능
 * 2) 두 추의 차가 0보다 크다면 -> 한쪽 저울에 있던 추중 하나 빼기
 * 이 점화식을 잘 생각해야 한다.
 */
public class dp04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine().trim());
        int[] weight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int chkSize = Integer.parseInt(br.readLine().trim());
        int[] chkWeight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sumOfBell = Arrays.stream(weight).sum();
        boolean[][] dp = new boolean[size+1][sumOfBell+1];

        dp[0][0] = true;

        for (int i = 1; i <= size; i++) {
            for (int j = 0; j <= sumOfBell; j++) {
                if(dp[i-1][j]){
                    dp[i][j] = true;
                    if(j + weight[i-1] <= sumOfBell){
                        dp[i][j + weight[i-1]] = true;
                        dp[i][Math.abs(j - weight[i-1])] = true;
                    }
                    if(j - weight[i-1] >= 0){
                        dp[i][j - weight[i-1]] = true;
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();

        for (int i : chkWeight) {
            if(i <= sumOfBell && dp[size][i]){
                sb.append("Y ");
            }else{
                sb.append("N ");
            }
        }

        System.out.println(sb.toString().trim());

    }
}

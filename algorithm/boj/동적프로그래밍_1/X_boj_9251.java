package dp_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj_9251

/**
 * 틀렸었던 문제. 두 문자열이 주어졌을떄, 그중 최고로 긴 부분수열을 어떻게 찾을 것인가? 를 물어보는 문제다 (LCS : Longest Common Subsequence)
 * 다양한 종류의 dp방법이 있었다. 이건 그중에서 또 다른 문제로 최장 길이 순열은 반복문 두개를 사용한다
 * 그래서 [0....i][0....j] 의 이차원 배열에서 첫번째 문자열의 길이 (ex : a, c, {a,c}) 와 오른쪽 문자열의 길이 (ex : c, a, {c, a})를 계속 비교해준다
 * 그 후 이차원 배열에서 만약 첫번째 문자열의 i번째 인덱스가 두번째 문자열의 j번째 인덱스와 같은 경우 map[i][j] = map[i-1][j-1] + 1 을 해준다는 규칙을 가지고 있었다.
 * 그렇지 않다면 map[i][j-1], map[i-1][j] 중 최댓값을 사용했다. 이 규칙을 이용해 점화식을 구성하여 문제를 풀면 된다.
 */
public class dp15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fStrTemp = " " + br.readLine().trim();
        String sStrTemp = " " + br.readLine().trim();

        char[] fStr = fStrTemp.toCharArray();
        char[] sStr = sStrTemp.toCharArray();

        int[][] map = new int[sStr.length][fStr.length];
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < sStr.length; i++) {
            for (int j = 1; j < fStr.length; j++) {
                if(sStr[i] == fStr[j]){
                    map[i][j] = map[i-1][j-1]+1;
                }else{
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
                }
                ans = Math.max(map[i][j], ans);
            }
        }


        System.out.println(ans);
    }
}

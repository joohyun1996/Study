package dp_second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// boj 1520

/**
 * dfs+dp를 같이 써서 푸는 문제
 * 단순히 dfs만 쓰면 시간초과가 난다! (방문한 길을 또 가고 또 가고 또 가니까... 가지치기를 해도 의미없음)
 * 따라서 갔던길을 기억하는 dp배열을 만들고, 방문했던 길이면 해당 값을 return. 도착지에 도달하면 -1 return
 * dp[0][0]은 결국 모든 길로 가는 방법의 수를 담게된다. 반대로 dp[n-1][m-1]에 인접한 인덱스는 1만 담게 된다.
 * 처음 만나보는 유형의 문제라 어려웠다.
 * 슬프게도 다시 풀었지만 틀렸다. DP 점화식에 대한 이해가 좀 더 필요할 듯 하다
 */
public class dp03 {
    static int[][] map, dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(dp[i], -1);
        }

        int ans = dfs(0, 0);

        System.out.println(ans);
    }

    public static int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        }
        if (dp[x][y] != -1){
            return dp[x][y];
        }

        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            if (tmpX >= 0 && tmpX < n && tmpY >= 0 && tmpY < m && map[x][y] > map[tmpX][tmpY]) {
                dp[x][y] += dfs(tmpX, tmpY);
            }
        }

        return dp[x][y];
    }
}

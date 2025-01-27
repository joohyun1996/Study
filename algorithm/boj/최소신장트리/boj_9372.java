package MinimumSpanTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// boj 9372

/**
 * MST를 사용해서 최단거리를 구하는 문제.
 * 나는 기본 DFS를 사용해서 풀었다. 이렇게 푸는게 맞는지는...모르겠다
 * ++ 왜냐하면 (당연하게도) MST에서 최소 거리는 N-1이기 떄문 ㅋㅋㅋㅋㅋ
 */
public class mst01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < tc; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int n = inputs[0];
            int m = inputs[1];

            for (int j = 0; j < m; j++) {
                int[] tmps = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                /*islandList.get(tmps[0]).add(tmps[1]);
                islandList.get(tmps[1]).add(tmps[0]);
                 */
            }
            System.out.println(n-1);

            /*for (int j = 1; j <= n ; j++) {
                chk = new boolean[n+1];
                cnt = 0;
                dfs(j, n);
                if(cnt < ans && cnt != 0){
                    ans = cnt;
                }
            }
            System.out.println(ans);*/
        }
    }

   /* public static void dfs(int start, int end) {
        chk[start] = true;

        ArrayList<Integer> tmpList = islandList.get(start);

        for (Integer i : tmpList) {
            if(!chk[i]){
                cnt++;
                dfs(i, end);
            }
        }
    }*/
}

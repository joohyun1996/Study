package graphAndTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// boj_2583

/**
 * 평범한 bfs 문제
 * 다만 1사분면을 4사분면으로 바꾸는걸 계산하는게 귀찮았다.
 */
public class gt15 {
    static ArrayList<Integer> ansList;
    static int n,m,k;
    static boolean[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];

        ansList = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int x1 = arr[0];
            int y1 = n - arr[1];
            int x2 = arr[2];
            int y2 = n - arr[3];

            for (int j = y2; j < y1; j++) {
                for (int l = x1; l < x2; l++) {
                    map[j][l] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!map[i][j]){
                    map[i][j] = true;
                    bfs(i,j);
                }
            }
        }

        Collections.sort(ansList);

        System.out.println(ansList.size());
        for (Integer i : ansList) {
            System.out.printf(i + " ");
        }
    }

    public static void bfs(int sY, int sX){
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{sY, sX});
        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] tmp = queue.pop();

            int y = tmp[0];
            int x = tmp[1];

            for (int i = 0; i < 4; i++) {
                int tY = y + dy[i];
                int tX = x + dx[i];

                if(tX >= 0 && tX < m && tY >= 0 && tY < n && !map[tY][tX]){
                    queue.add(new int[]{tY, tX});
                    map[tY][tX] = true;
                    cnt++;
                }
            }
        }

        ansList.add(cnt);
    }
}

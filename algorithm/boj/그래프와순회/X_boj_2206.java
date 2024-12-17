package graphAndTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// boj 2206

/**
 * 벽을 뚫고가는 경우 bfs를 어떻게 적용해야 하는가?
 * 3차원 chk 배열을 사용해서 지나간 길, 지나가지 않은길을 체크해 줘야함
 * 굉장히 어려워서 보고 푼 문제
 * 벽이 있으면 -> 벽을 부순적이 없는가? 해당 벽을 이전에 부수고 방문한적이 없는지?
 * 벽이 없으면 -> 벽을 부순 여부에 따라 다음 칸 방문체크
 */
public class gt13 {
    static int[][] graph;
    static int[][] wayPoint;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = inputs[0];
        int m = inputs[1];


        graph = new int[n][m];
        wayPoint = new int[n][m];
        visited = new boolean[2][n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        if(n == 1 && m == 1){
            System.out.println(1);
            return;
        }

        Deque<int[]> arrayList = new ArrayDeque<>();
        arrayList.add(new int[]{0,0,0});
        visited[0][0][0] = true;
        wayPoint[0][0] = 0;

        while(!arrayList.isEmpty()){
            int[] currentPosition = arrayList.poll();
            int x = currentPosition[0];
            int y = currentPosition[1];
            int broken = currentPosition[2];

            for (int i = 0; i < 4; i++) {
                int tmpX = x + dx[i];
                int tmpY = y + dy[i];

                if(tmpX < 0 || tmpX >= n || tmpY < 0 || tmpY >= m) {
                    continue;
                }

                if(graph[tmpX][tmpY] == 1 && broken == 0 && !visited[1][tmpX][tmpY]){
                    visited[1][tmpX][tmpY] = true;
                    arrayList.add(new int[]{tmpX, tmpY, 1});
                    wayPoint[tmpX][tmpY] = wayPoint[x][y] + 1;
                } else if(graph[tmpX][tmpY] == 0 && !visited[broken][tmpX][tmpY]){
                    visited[broken][tmpX][tmpY] = true;
                    arrayList.add(new int[]{tmpX, tmpY, broken});
                    wayPoint[tmpX][tmpY] = wayPoint[x][y] + 1;
                }

                if(tmpX == n-1 && tmpY == m-1){
                    System.out.println(wayPoint[tmpX][tmpY]+1);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}

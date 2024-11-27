package graphAndTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// boj 1012

/**
 * 그래프에서 최소 탐색 길이를 bfs 로 풀 수 있나요? 하고 물어보는 문제. 어렵지 않다
 */
public class gt08 {
    static boolean[][] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] graph = new int[arr[0]][arr[1]];
            int depth = 0;

            chk = new boolean[arr[0]][arr[1]];

            for (int j = 0; j < arr[2]; j++) {
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                graph[input[0]][input[1]] = 1;
            }

            for (int j = 0; j < arr[0]; j++) {
                for (int k = 0; k < arr[1]; k++) {
                    if(!chk[j][k] && graph[j][k] == 1){
                        depth += bfs(graph, new Pair(j,k));
                    }
                }
            }

            System.out.println(depth);
        }
    }

    public static int bfs(int[][] graph, Pair pair){
        Deque<Pair> queue = new ArrayDeque<>();
        queue.add(pair);

        while(!queue.isEmpty()){
            Pair tmp = queue.pollFirst();

            int x = tmp.getX();
            int y = tmp.getY();

            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};

            for (int i = 0; i < 4; i++) {
                int tmpX = x + dx[i];
                int tmpY = y + dy[i];

                if(tmpX >= 0 && tmpX < graph.length && tmpY >= 0 && tmpY < graph[0].length && graph[tmpX][tmpY] == 1 && !chk[tmpX][tmpY]){
                    chk[tmpX][tmpY] = true;
                    queue.add(new Pair(tmpX,tmpY));
                }
            }
        }

        return 1;
    }

    public static class Pair{
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}

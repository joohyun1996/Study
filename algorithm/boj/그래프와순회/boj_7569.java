package graphAndTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// boj 7569

/**
 * 이전 토마토 문제를 3차원으로 만든 문제. 3차원을 담당하는 변수가 들어오면 어떻게 할래?
 * 하고 물어보는 문제이다.
 */
public class gt11 {
    static int[][][] graph;
    static Deque<Tomato> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = arr[1];
        int m = arr[0];
        int h = arr[2];

        graph = new int[h][n][m];
        queue = new ArrayDeque<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(graph[i][j][k] == 1){
                        queue.add(new Tomato(j,k,i));
                    }
                }
            }
        }

        bfs(n, m, h);

        int ans = -1;

        for (int[][] ints : graph) {
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    if(i == 0){
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(ans, i);
                }
            }
        }
        System.out.println(ans-1);
    }
    public static void bfs(int x, int y, int h){
        int[] dx = {1,-1,0,0,0,0};
        int[] dy = {0,0,-1,1,0,0};
        int[] dh = {0,0,0,0,-1,1};

        while(!queue.isEmpty()){
            Tomato tmp = queue.pollFirst();

            for (int i = 0; i < 6; i++) {
                int tmpX = tmp.getX() + dx[i];
                int tmpY = tmp.getY() + dy[i];
                int tmpZ = tmp.getZ() + dh[i];

                if(tmpX >= 0 && tmpX < x && tmpY >= 0 && tmpY < y && tmpZ >= 0 && tmpZ < h && graph[tmpZ][tmpX][tmpY] == 0){
                    graph[tmpZ][tmpX][tmpY] = graph[tmp.getZ()][tmp.getX()][tmp.getY()] + 1;
                    queue.add(new Tomato(tmpX, tmpY, tmpZ));
                }
            }
        }
    }
    public static class Tomato{

        private int x;
        private int y;
        private int z;

        public Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }

}

package graphAndTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// boj 7576

/**
 * 최소길이 경로는 구하는 bfs의 대표문제
 * 한번 틀렸다. 그 이유는 시작점과 끝점으로 생각하고 문제를 풀었는데, 그게 아니라 끝점이 없는 두 시작점이 중간에 만나는 길이를 재었어야 했기 때문
 * 최적화는 할 수 잇을것 같다. (필요없는 이차원 배열 두개 지워서 최적화 완료)
 */
public class gt10 {
    static int[][] graph;
    static Deque<Pair> queue;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = input[1];
        int m = input[0];

        graph = new int[n][m];
        queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] == 1) {
                    queue.add(new Pair(i,j));
                }
            }
        }
        bfs(n, m);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(graph[i][j], ans);
            }
        }

        System.out.println(ans-1);
    }

    public static void bfs(int x, int y){
        while(!queue.isEmpty()){
            Pair tmp = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int tmpX = tmp.getX() + dx[i];
                int tmpY = tmp.getY() + dy[i];

                if(tmpX >= 0 && tmpX < x && tmpY >= 0 && tmpY < y && graph[tmpX][tmpY] == 0){
                    graph[tmpX][tmpY] = graph[tmp.getX()][tmp.getY()]+1;
                    queue.add(new Pair(tmpX, tmpY));
                }
            }
        }
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
